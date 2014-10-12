package statistics.matcher;

import java.util.ArrayList;

public class QueryBuilder {
    
    private ArrayList<Matcher> andMatches;
    private ArrayList<Matcher> orMatches;
    
    public QueryBuilder(){
        this.andMatches=new ArrayList<Matcher>();
        this.orMatches=new ArrayList<Matcher>();
    }
    
    public QueryBuilder hasAtLeast(int value, String category){
        this.andMatches.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category){
        this.andMatches.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder playsIn(String team){
        this.andMatches.add(new PlaysIn(team));
        return this;
    }
    
    public Matcher build(){
        //return new And((Matcher[]) this.andMatches.toArray());
        Matcher ret=null;
        if(this.andMatches.size()>0){
            ret=new And((Matcher[]) this.andMatches.toArray());
        }
        if(this.orMatches.size()>0){
            ret=new Or((Matcher[]) this.orMatches.toArray());
        }        
        this.andMatches=new ArrayList<Matcher>();
        this.orMatches=new ArrayList<Matcher>();
        return ret;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2){
        this.orMatches.add(m1);
        this.orMatches.add(m2);
        return this;
    }
    
}
