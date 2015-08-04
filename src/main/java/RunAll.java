/**
 * This simply runs all the samples, after a successful run, you
 * can compare the results by looking at templates from resources
 * and output files on the root.
 *
 * Created by mohamnag on 04/08/15.
 */
public class RunAll {

    public static void main(String[] args) {
        OdtVelocityMap.main(args);
        OdtVelocityPojo.main(args);
        XdocVelocityMap.main(args);
        XdocVelocityPojo.main(args);
    }

}
