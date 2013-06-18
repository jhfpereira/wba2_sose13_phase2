package de.fhkoeln.gm.wba2.phase2.client;


public class ColourWrapper {
    private String hexList = "0123456789abcdef";
    private int[] rgb = new int[3];
    private String hexCode = "";
    
    public ColourWrapper() {
        this(255, 255, 255); // white
    }
    
    public ColourWrapper(String hexCode) {
        
        if(hexCode.length() > 6) {
            hexCode = hexCode.substring(0, 6);
        }
        else if(hexCode.length() == 3) {
            hexCode =   hexCode.charAt(0) + "" + hexCode.charAt(0) + "" +
                        hexCode.charAt(1) + "" + hexCode.charAt(1) + "" +
                        hexCode.charAt(2) + "" + hexCode.charAt(2);
        }
        else if(hexCode.length() != 6)    {
            for(int i=hexCode.length()-1; i <= 6; i++) {
                hexCode += "f";
            }
        }
        
        this.hexCode = hexCode;
        
        
        for(int i = 0; i < 3; i++) {
            this.rgb[i] =   hexList.indexOf(this.hexCode.charAt(i*2)) * 16
                          + hexList.indexOf(this.hexCode.charAt(i*2+1));
        }
    }
    
    public ColourWrapper(int r, int g, int b) {
        this.rgb[0] = r;
        this.rgb[1] = g;
        this.rgb[2] = b;
        
        for(int i = 0; i < 3; i++) {
            this.hexCode += hexList.charAt((this.rgb[i] >> 4) & 15);
            this.hexCode += hexList.charAt((this.rgb[i] & 15));
        }
        
        
    }
    
    public int getRed() {
        return this.rgb[0];
    }
    
    public int getGreen() {
        return this.rgb[1];
    }
    
    public int getBlue() {
        return this.rgb[2];
    }
    
    public String getHexCode() {
        return this.hexCode;
    }
}
