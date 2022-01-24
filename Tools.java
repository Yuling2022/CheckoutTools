package main.java.com.company;

public class Tools {
     public String toolCode;
     public String toolType;
     public String toolBrand;
     public double toolPrice;

     public Tools(String toolCode){
         this.toolCode = toolCode;
     }

     public String getToolCode(){
         return this.toolCode;
    }

    public String getToolType(){
         switch(this.toolCode){
             case "CHNS":  this.toolType = "Chainsaw";
                break;
             case "LADW":  this.toolType = "Ladder";
                 break;
             case "JAKD":
             case "JAKR":
                 this.toolType = "Jackhammer";
                 break;
             default:
               break;
         }
        return this.toolType;
    }

    public String getToolBrand(){
        switch(this.toolCode){
            case "CHNS": this.toolBrand = "Stihl";
                break;
            case "LADW": this.toolBrand = "Werner";
            case "JAKD": this.toolBrand = "Dewalt";
                break;
            case "JAKR": this.toolBrand = "Ridgit";
                break;
            default:
                break;
        }
        return this.toolBrand;
    }

    public double getPrice(String toolType){
        switch(toolType){
            case "Ladder": this.toolPrice= 1.99;
                break;
            case "Chainsaw": this.toolPrice = 1.49;
                break;
            case "Jackhammer": this.toolPrice = 2.99;
                break;
            default:
                break;
        }
        return this.toolPrice;
    }

    public static void main(String[] args) {

         Tools tools = new Tools("JAKD");
        System.out.println(tools.getToolCode());
        System.out.println(tools.getToolType());
        System.out.println(tools.getToolBrand());
        System.out.println(tools.getPrice("ladder"));
    }

}
