/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author l0011
 */
public enum Resource {
    /**
     * Types
     */
    PLUMBER(120,"PLUMBER"), CARPENTER(120, "CARPENTER"), ELECTRICIAN(120, "ELECTRICIAN"), 
    MASON(120, "MASON"), LABOURER(80, "LABOURER"), PLASTERER(120, "PLASTERER"), 
    GLAZIER(120, "GLAZIER"), PAINTER(120, "PAINTER"), PLANT(150, "PLANT"), 
    LANDSCAPER(120, "LANDSCAPER"), APPRENTICE(60, "APPRENTICE");
    /**
     * Values
     */
    private final int price;
    private final String display;
    
    /**
     * Constructor
     * @param price
     * @param display 
     */
    private Resource(int price, String display){
        this.price = price;
        this.display = display;
    }
    
    /**
     * 
     * @return Price
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * 
     * @return Name of resource
     */
    @Override
    public String toString(){
        return display;
    }
    
    public static String[] enumsToStringArray(){
        Resource[] resources = values();
        String[] names = new String[resources.length];
        
        for(int i = 0; i < names.length; i++){
            names[i] = resources[i].toString();
        }
        return names;
    }
    
    public static Resource fromString(String text){
        for(Resource r: Resource.values()){
            if(r.display.equalsIgnoreCase(text))
                return r;
        }
        return null;
    }
}
