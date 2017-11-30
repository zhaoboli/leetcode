package tw;

public class Runner {

    public static void main(String[] args) {

        TrainRoute trainRoute = new TrainRoute("trainRoute.txt");

        System.out.println("case one: A-B-C");
        String input_case_one = "A-B-C";
        System.out.println(trainRoute.calculateRouteDistance(input_case_one).getValue());

        System.out.println("case two: A-D");
        String input_case_two = "A-D";
        System.out.println(trainRoute.calculateRouteDistance(input_case_two).getValue());

        System.out.println("case three: A-D-C");
        String input_case_three = "A-D-C";
        System.out.println(trainRoute.calculateRouteDistance(input_case_three).getValue());

        System.out.println("case four: A-E-B-C-D");
        String input_case_four = "A-E-B-C-D";
        System.out.println(trainRoute.calculateRouteDistance(input_case_four).getValue());

        System.out.println("case five: A-E-D");
        String input_case_five = "A-E-D";
        System.out.println(trainRoute.calculateRouteDistance(input_case_five).getMessage());

        System.out.println("Case six: C C");
        RouteResult actual = trainRoute.searchPathMaxStops("C", "C", 3);
        System.out.println(actual.getValue());

        System.out.println("Case seven: A C");
        RouteResult actual_seven = trainRoute.searchPathExactStops("A", "C", 4);
        System.out.println(actual_seven.getValue());

        System.out.println("case eight: A C");
        RouteResult actual_eight = trainRoute.searchPathShortestDistance("A", "C");
        System.out.println(actual_eight.getValue());

        System.out.println("case nine: B B");
        RouteResult actual_nine = trainRoute.searchPathShortestDistance("B", "B");
        System.out.println(actual_nine.getValue());

        System.out.println("case ten:C C");
        RouteResult actual_ten = trainRoute.searchPathMaxDistance("C", "C", 30);
        System.out.println(actual_ten.getValue());
    }
}
