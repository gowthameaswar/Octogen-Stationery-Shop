import java.util.Scanner;

abstract class Stationary {
    Scanner sc = new Scanner(System.in);
    int item_id, item_amount, item_quantity;
    String item_name;
    public abstract void addNewItem();
    public abstract void viewExistingItem();
    public abstract int getItemPrice();

    
}

class Items extends Stationary {
    public void addNewItem(){
        System.out.print("Enter Product id:");
        item_id = sc.nextInt();
        System.out.print("Enter Product name:");
        item_name = sc.next();
        System.out.print("Enter Price:");
        item_amount = sc.nextInt();
        System.out.print("Enter Quantity:");
        item_quantity = sc.nextInt();  
    }
    @Override
    public void viewExistingItem(){
        System.out.println(item_id + "\t    " + item_name + "\t    " + item_quantity + "\t       " + item_amount);
    }
    @Override
    public int getItemPrice(){
        return item_amount;
    }
    public static void displayFormat() {
    System.out.print(
        "\nName      Quantity    Price   Total Price\n");
  }
    public static void dispformat2() {
    System.out.print(
        "\nID         Name      Quantity    Price   \n");
  }
    public static void dispformat() {
    System.out.print(
        "\nID         Price   \n");
  }
}


class Total{
    Scanner sc = new Scanner(System.in);
    int purchaseid, purchaseamt; 
    public void addBill(int a, int b){
        purchaseid = a;
        purchaseamt = b;
    }
    public void dispBill(){
        System.out.println(purchaseid + "        " + purchaseamt);
    }
    
}


public class Octogen {    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int choice, product_temp=0, purchase_temp=0, temp1=0;
        int ch, temp, m, n;
        Items[] i = new Items[100];
        System.out.println("\tOCTOGEN-The World of Stationary");
        Total[] b = new Total[100];
        while(true){
           System.out.println("\n1. ITEM MANAGEMENT \n2. USER \n3. EXIT\n");
           System.out.print("Enter the choice: ");
           choice = input.nextInt();
           
           switch(choice){
               case 1:
                   System.out.println("\t1. Add new Product\n\t2. Search Products\n\t3. View all Products\n\t4. Search Purchase\n\t5. View all purchase amounts");
                   System.out.print("Please enter your choice: ");
                   ch = input.nextInt();
                   switch(ch){
                       case 1:
                           i[product_temp] = new Items();
                           i[product_temp].addNewItem();
                           product_temp++;
                           break;
                       case 2:
                           System.out.print("Enter Product id :");
                           temp = input.nextInt();
                           Items.dispformat2();
                           for (m = 0; m < product_temp; m++){
                               if (i[m].item_id == temp){
                                   i[m].viewExistingItem();
                               }
                           }
                           break;
                       case 3:
                           Items.dispformat2();
                           for (n = 0; n < product_temp; n++){
                               i[n].viewExistingItem();                                   
                                   }
                           break;
                        case 4:
                           System.out.print("Enter Purchase id :");
                           int temp3 = input.nextInt();
                           Items.dispformat();
                           for (int l = 0; l < purchase_temp; l++){
                               if (temp3 == b[l].purchaseid){b[l].dispBill();}                               
                           }
                           break;
                       case 5:
                           Items.dispformat();
                           for (int l = 0; l < purchase_temp; l++){
                               b[l].dispBill();
                           }
                           
                           break;
                       default:
                           System.out.println("Invalid Input");
                           break;
                   }
                   break;
               case 2:
                   System.out.println("\t1. New Purchase\n\t2. Back to main menu.");
                   ch = input.nextInt();
                   int cont = 0;
                   switch(ch){
                       case 1:{
                           
                           String[][] arr = new String[50][4];
                           int sum=0;
                           int cnt = 0;
                           do{
                           
                           for (n = 0; n < product_temp; n++){
                              
                               i[n].viewExistingItem();
                                   }
                           System.out.println("Enter the product id: ");
                           int tempp = input.nextInt();
                           System.out.println("Enter Quantity: ");
                           int quant = input.nextInt();
                           int ItemPrice;
                           for (m = 0; m < product_temp; m++){
                               if (i[m].item_id == tempp){
                                      
                                   i[m].item_quantity = i[m].item_quantity - quant;
                                   ItemPrice = i[m].getItemPrice();
                                   sum += ItemPrice*quant; 
                                   arr[cnt][0] = i[m].item_name;
                                   arr[cnt][1] = String.valueOf(i[m].item_quantity);
                                   arr[cnt][2] = String.valueOf(ItemPrice);
                                   arr[cnt][3] = String.valueOf(ItemPrice*quant);
                                   cnt++;
                           }  }
                           System.out.println("Want to purchase some more items ? :\n\t (Yes-1/No-1)\t");
                            
                           cont = input.nextInt();
                           }while(cont == 1); 
                           Items.displayFormat();
                              
                          for (int p = 0; p < cnt; p++) {
                              System.out.println(arr[p][0]+"      "+arr[p][1]+"         "+arr[p][2]+"         "+arr[p][3 ]);
                            }
                           b[purchase_temp] = new Total();
                           b[purchase_temp].addBill(purchase_temp + 1, sum);
                           purchase_temp++;
                           System.out.println("Total Bill :" + sum);
                           break;}
                       case 2:
                           System.out.println("Back to main menu..");
                           break;
                       default:
                           System.out.println("Invalid Input");
                           break;
                   }
               
               default :
                   System.exit(0);     
           }
        }        
    }    
}