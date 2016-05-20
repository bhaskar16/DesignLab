package com.Cerebro.Controller;

import java.util.Date;

/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
import java.util.Calendar;
import java.util.LinkedList;

import com.Cerebro.Entity.Tutor;
import com.Cerebro.Entity.TutorList;

import java.util.Collections;
import java.util.Comparator;
import java.text.SimpleDateFormat;
public class SearchEngine {
	
	private String discipline;
	private String disc_sub;
	private double remuneration_low;
	private double remuneration_high;
	private String day_slots;
	private LinkedList<String> time_slots;
	private String location;
	private int experience;
	private String age;
	private String gender;
	private String batch_size;
	private boolean agent_registered;
	private String priority;
	private boolean valid;
	private String[] errorMsg;
	private int errCount;
	
	private class Result {
		private Tutor tut;
		private double score;
		public Result(Tutor t, double sc) {
			tut = new Tutor(t);
			score = sc;
		} public Tutor tutor(){return tut;}
		public void setScore(double d){score = d;}
		public double getScore(){return score;}
		public String toString() {
			String str = "ID: " + tut.getProfileId() + ", Name: "
			+ tut.getName() + ", Score: " + score;
			return str;
		}
	}
	
	private class ResultComp implements Comparator<Result> {
		public int compare(Result r1, Result r2) {
			if(r1.getScore() <= r2.getScore()){
				return 1;
			} else {
				return -1;
			}
		}
	}
	
	public SearchEngine(String disc, String d_sub, double rem_l, double rem_h, String dsl, String[] ts,
						String loc, int exp, String agexp, String gen, String bsize, String ag_reg) {
		
		valid = true;errorMsg = new String[12];errCount = -1;
		try { 
			if(disc == null || disc.equals("")) discipline = null;
			else discipline = disc;
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Discipline"; }
		try { 
			if(d_sub == null || d_sub.equals("")) disc_sub = null;
			else disc_sub = d_sub;
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Discipline-Sub-Category"; }
		try { 
			if(rem_h < rem_l) { 
				valid = false;
				errorMsg[++errCount] = "Remuneration Low Larger than Remuneration High";
			} else if(rem_h < 0 || rem_l < 0){
				valid = false;
				errorMsg[++errCount] = "Negative Remuneration Not Allowed";
			} else {
				remuneration_low = rem_l;remuneration_high = rem_h;
			}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Remuneration Range"; }
		try {
			if(dsl == null || dsl.equals("")) day_slots = null;
			else {
				if(dsl.length() > 7) {
					valid = false;
					errorMsg[++errCount] = "No more than 7 days a week";
				} else if (dsl.length() < 7) {
					valid = false;
					errorMsg[++errCount] = "No less than 7 days a week";
				} else {
					boolean flag = true;int zero_count = 0;
					for(int i=0;i<7;i++) {
						if(!(dsl.charAt(i) == '0' || dsl.charAt(i) == '1')) {
							flag = false;break;
						} else {if(dsl.charAt(i) == '0') zero_count++;}
					} if(flag == false) {
						valid = false;errorMsg[++errCount] = "Invalid Day slots";
					} else if(zero_count == 7){
						valid = false;errorMsg[++errCount] = "No days specified.";
					} else { day_slots = dsl; }
				}
			}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Day Slots"; }
		try {
			if(ts == null) {time_slots = null;}
			else {
				time_slots = new LinkedList<String>();
				if(ts.length > 5 || ts.length <=0) {
					valid = false;time_slots = null;
					errorMsg[++errCount] = "Invalid Number of Time slots";
				} else {
					boolean flag = true;
					for(int i=0;i<ts.length;i++){
						String[] tslot = ts[i].split("-");
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						sdf.setLenient(false);
						Date t1 = sdf.parse(tslot[0]);Date t2 = sdf.parse(tslot[1]);
						if(t2.before(t1)){flag = false;break;}
						else {time_slots.add(ts[i]);}
					} if(!flag) {
						valid = false;time_slots = null;
						errorMsg[++errCount] = "Invalid Time slots";
					}
				}
			}
		} catch(Exception e) { valid = false;time_slots = null;
			errorMsg[++errCount] = "Invalid Time Slots"; }
		try {
			if (loc == null || loc.equals("")) {
				loc = null;
			} else if (loc.equals("Home")) {
				location = "Any Location";
			} else {
				location = loc;
			}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Location"; }
		try {
			if (exp < 0 || exp > 40) {
				valid = false;errorMsg[++errCount] = "Experience Out of range";
			} else experience = exp;
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Experience Preference"; }
		try {
			if(agexp == null || agexp.equals("")) age = null;
			else if(agexp.equals("18-25") || agexp.equals("25-30") || agexp.equals("30-40")
				|| agexp.equals("40-50") || agexp.equals("Above 50")) {age = agexp;}
			else {valid = false;errorMsg[++errCount] = "Invalid Age Preference";}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Age Preference"; }
		try {
			if(gen == null || gen.equals("")) gender = null;
			else if(gen.equals("male") || gen.equals("female")) {gender = gen;}
			else {valid = false;errorMsg[++errCount] = "Invalid Gender Preference";}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Gender Preference"; }
		try {
			if(bsize == null || bsize.equals("")) batch_size = null;
			else if(bsize.equals("Single") || bsize.equals("Upto 5") ||
				bsize.equals("Upto 10") || bsize.equals("Any")) {batch_size = bsize;}
			else {valid = false;errorMsg[++errCount] = "Invalid Batch Size Preference";}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Batch Size Preference"; }
		try {
			if(ag_reg == null || agexp.equals("")) agent_registered = false;
			else if(ag_reg.equals("true")) {agent_registered = true;}
			else if (ag_reg.equals("false")) {agent_registered = false;}
			else {valid = false;errorMsg[++errCount] = "Invalid Agent Registration Preference";}
		} catch(Exception e) { valid = false;errorMsg[++errCount] = "Invalid Agent Registration Preference"; }
		
		System.out.println("Done");
	}
	
	public boolean isValid() {
		return valid;
	}
	
	public String[] getErrorMessage() {
		return errorMsg;
	}
	
	public Tutor[] search() {
		if(valid) {
			TutorList tl = new TutorList();
			LinkedList<Tutor> list = tl.searchTutors(discipline, disc_sub, gender, agent_registered);
			LinkedList<Result> optimizedList = addScores(list);
			Collections.sort(optimizedList, new ResultComp());
			Tutor[] finalList = new Tutor[optimizedList.size()];
			for(int i=0;i<finalList.length;i++) {
				Tutor t = new Tutor((optimizedList.get(i)).tutor());
				finalList[i] = t;
			} //System.out.println();
			System.out.println(list.size());
			System.out.println(optimizedList.size());
			//System.out.println("Done"+finalList[0].getName());
			return finalList;
		} else {
			return null;
		}
	}
	
	private LinkedList<Result> addScores(LinkedList<Tutor> list) {
		LinkedList<Result> l = new LinkedList<Result>();
		for(int i=0;i<list.size();i++) {
			Tutor tut = list.get(i);
			Result r = new Result(tut, 0);
			if(tut.getRem() >= remuneration_low && tut.getRem() <= remuneration_high) {
				double sc = r.getScore();sc += 1000/*(priority)*/;r.setScore(sc);
			} if(matchByDaySlots(tut.getDS())) {
				double sc = r.getScore();sc += 100/*(priority)*/;r.setScore(sc);
			} if(matchByDaySlots(tut.getTS())) {
				double sc = r.getScore();sc += 100/*(priority)*/;r.setScore(sc);
			} if(location != null && location.equals(tut.getLocation())) {
				double sc = r.getScore();sc += 10000/*(priority)*/;r.setScore(sc);
			} if(tut.getExp() >= experience) {
				double sc = r.getScore();sc += 10/*(priority)*/;r.setScore(sc);
			} if(matchByAge(tut.getdob())) {
				double sc = r.getScore();sc += 1/*(priority)*/;r.setScore(sc);
			} if(batch_size != null && batch_size.equals(tut.batchSize())) {
				double sc = r.getScore();sc += 5000/*(priority)*/;r.setScore(sc);
			} l.add(r);
		} return l;
	}
	
	private boolean matchByAge(String d_o_b) {
		if(age == null){
			return false;
		} SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();Date dob = null;
		try {dob = sdf.parse(d_o_b);}
		catch(Exception e) {dob = new Date();}
		Calendar a = Calendar.getInstance();
		Calendar b = Calendar.getInstance();
		a.setTime(dob);b.setTime(today);
		int age_val = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
			(a.get(Calendar.MONTH) == b.get(Calendar.MONTH) 
			&& a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
			age_val--;
		} if (age.equals("18-25")) {
			if(age_val >= 18 && age_val <= 25) return true;
			else return false;
		} else if (age.equals("25-30")) {
			if(age_val >= 25 && age_val <= 30) return true;
			else return false;
		}  else if (age.equals("30-40")) {
			if(age_val >= 30 && age_val <= 40) return true;
			else return false;
		}  else if (age.equals("40-50")) {
			if(age_val >= 40 && age_val <= 50) return true;
			else return false;
		} else {
			if(age_val >= 50) return true;
			else return false;
		} 
	}
	
	private boolean matchByDaySlots(String dslots) {
		if (day_slots == null) {
			return false;
		} for(int i=0;i<day_slots.length();i++) {
			if(day_slots.charAt(i) == dslots.charAt(i)) {
				return true;
			}
		} return false;
	}
	
	private boolean matchByTimeSlots(String tslots) {
		if (time_slots == null) {
			return false;
		} String[] t_slots = tslots.split(",");
		for(int i=0;i<t_slots.length;i++) {
			if(time_slots.contains(t_slots[i])){
				return true;
			}
		} return false;
	}	
	
}