/**
 Test list features.
 */

public class UserOfList {
    private static List_inArraySlots list;
    private static List_inArraySlots newList;

    public static void main( String[] args ) {
        list = new List_inArraySlots();

        System.out.println( "number of elements: " + list.size() );
        System.out.println( "empty list: " + list);

        // Populate the list with diverse elements.
        list.add( "important");
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added string: " + list);

        list.add( 17);
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added int: " + list);

        list.add( 1.618);
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added double: " + list);

        list.add( -2.0);
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added double: " + list);

        // Add enough elements that expansion is expected
        for( int elemIndex = list.size(); elemIndex < 15; elemIndex++ ) {

            if( list.size() == 10) System.out.println( "expansion expected");

            list.add( -elemIndex);
            System.out.println( "number of elements: " + list.size() );
        }
        System.out.println("result of expanded list: "
             + list.size() + " elements:");

        System.out.println( list + System.lineSeparator());

        for (int i = 0; i < list.size(); i++){
            System.out.println ( "" + i + " : " + list.get(i));
        }
        
        newList = new List_inArraySlots();
        newList.add( 3.14);
        newList.add( "piazza");
        newList.add( 6.28);
        newList.add( "pi");
        newList.add( Double.POSITIVE_INFINITY);
        newList.add( "tau");
        newList.add( "pizza");
        newList.add( 1e4);
        newList.add( Double.NEGATIVE_INFINITY);
        System.out.println( Accumulator.catElementsStartingWith( newList, "pi"));
        System.out.println( Accumulator.finites( newList));
        
    }
}
