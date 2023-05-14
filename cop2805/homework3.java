package cop2805;

class homework3 {

	 public static <E extends Comparable<E>> E min(E [] list){
	 		  E minVal = list[0];
	 		  
	 		  for (int i = 1; i < list.length; i++){
	 			  if (list[i].compareTo(minVal) < 0){
	 				  minVal = list[i];
	 			  }
	 		  }
	 		  return minVal;
	  }

	 public static void main(String[] args){
		  String[] colors = {"Red", "Green", "Blue"};
		  Integer[] numbers = {1, 2, 3};
		  Double[] circleRadius = {3.0, 5.9, 2.9};

		  System.out.println("Colors: " + min(colors));
		  System.out.println("Numbers: " + min(numbers));
		  System.out.println("Circle Radius: " + min(circleRadius));
	 }

}

