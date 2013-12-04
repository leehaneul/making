package com.example.a3r1;

public class InfoClass {
	
	public int _id;
	public String start;
	public String end;
	public String name;
	public String number;
	public String seat;

	public InfoClass(int _id , String start , String end, String name, String number, String seat){
    	this._id = _id;
		this.start = start;
		this.end = end;
		this.name = name;
		this.number = number;
		this.seat = seat;
    }
    public int getId() {
        return _id;
    }
    public void setId(int _id) {
        this._id = _id;
    }
    public String getStart() {
        return start;
    }
    public void getStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void getEnd(String end) {
        this.end = end;
    }
    public String getName() {
        return name;
    }
    public void getName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getSeat() {
        return seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    
}
