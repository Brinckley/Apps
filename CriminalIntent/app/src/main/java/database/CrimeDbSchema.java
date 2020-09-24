package database;

public class CrimeDbSchema {

    public static final class CrimeTable {
        public static final String NAME = "crimes"; //name for db
    }

    public static final class Cols{ //names for the columns in db
        public static final String UUID = "uuid";
        public static final String TITLE = "title";
        public static final String DATE = "date";
        public static final String SOLVED = "solved";
    }

}
