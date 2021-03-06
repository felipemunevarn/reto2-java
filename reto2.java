import java.util.Scanner;

public class reto2 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int number = Integer.parseInt(input.nextLine().strip());
    CuerpoDeAgua[] bodiesOfWater = new CuerpoDeAgua[number];
    float amountHighAndLow = 0;
    int amountMed = 0;
    double sum = 0;
    for (int i = 0; i < number; i++) {
      String[] temp = input.nextLine().split(" ");
      bodiesOfWater[i] = new CuerpoDeAgua(
        temp[0],
        Integer.parseInt(temp[1]),
        temp[2],
        Double.parseDouble(temp[3])
      );
      String catTemp = bodiesOfWater[i].nivel(bodiesOfWater[i].getIrca());
      if(catTemp == "ALTO" || catTemp == "MEDIO")
        amountHighAndLow++;
      sum += bodiesOfWater[i].getIrca();
    }

    for (int i = 0; i < number; i++)
      System.out.println(bodiesOfWater[i].getName());

    System.out.printf("%.2f%n",amountHighAndLow);

    for (int i = 0; i < number; i++){
      String catTemp = bodiesOfWater[i].nivel(bodiesOfWater[i].getIrca());
      if(catTemp == "ALTO"){
        System.out.print(bodiesOfWater[i].getName() + " ");
        amountMed++;
      }
    }

    if (amountMed == 0)
      System.out.print("NA");
    System.out.println("");
    System.out.printf("%.2f%n",sum / number);

    input.close();
  }
}
