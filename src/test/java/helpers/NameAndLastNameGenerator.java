package helpers;

import java.util.Random;

public class NameAndLastNameGenerator {
    private static final String[] firstNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard"
            , "Joseph", "Thomas", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul"
            , "Steven", "Andrew", "Kenneth", "Joshua", "George", "Kevin", "Brian", "Edward", "Ronald", "Timothy", "Jason"
            , "Jeffrey", "Ryan", "Jacob", "Gary", "Nicholas", "Eric", "Stephen", "Jonathan", "Larry", "Justin", "Scott"
            , "Brandon", "Benjamin", "Samuel", "Gregory", "Frank", "Alexander", "Raymond", "Patrick", "Jack", "Dennis", "Jerry"
            , "Tyler", "Aaron", "Jose", "Henry", "Adam", "Douglas", "Nathan", "Peter", "Zachary", "Kyle", "Walter", "Harold"
            , "Jeremy", "Ethan", "Carl", "Keith", "Roger", "Gerald", "Christian", "Terry", "Sean", "Arthur", "Austin", "Noah"
            , "Lawrence", "Jesse", "Joe", "Bryan", "Billy", "Jordan", "Albert", "Dylan", "Bruce", "Willie", "Gabriel", "Alan"
            , "Juan", "Logan", "Wayne", "Ralph", "Roy", "Eugene", "Randy", "Vincent", "Russell", "Louis", "Philip", "Bobby"
            , "Johnny", "Bradley", "Alberto", "Howard", "Frederick", "Martin", "Andre", "Elvis", "Edwin", "Don", "Wesley", "Allan"
            , "Emmanuel", "Jerome", "Mitchell", "Leonard", "Luis", "Ernest", "Nelson", "Curtis", "Alfred", "Cody", "Orlando", "Alex"
            , "Vernon", "Max", "Marvin", "Fernando", "Herman", "Luke", "Wade", "Freddie", "Javier", "Edgar", "Oscar", "Darrell", "Tony"
            , "Ian", "Maurice", "Lance", "Glen", "Sean", "Leon", "Melvin", "Derek", "Brent", "Preston", "Darryl", "Clarence", "Jesus"
            , "Alvin", "Perry", "Rickey", "Benny", "Leroy", "Theodore", "Gordon", "Pedro", "Willard", "Greg", "Rex", "Isaac", "Clifford"
            , "Andre", "Titus", "Levi", "Elijah", "Travis", "Ernesto", "Calvin", "Trevor", "Darren", "Gavin", "Caleb", "Henry", "Donald"
            , "Allen", "Felix", "Shawn", "Arturo", "Ramon", "Gregorio", "Leo", "Tomas", "Andy", "Franklin", "Dwayne", "Terrance", "Terrence"
            , "Nick", "Hector", "Armando", "Jorge", "Arnold", "Cesar", "Dean", "Colin", "Micheal", "Juan", "Lloyd", "Logan", "Phillip", "Garry"
            , "Tom", "Enrique", "Kurt", "Tracy", "Adrian", "Nathaniel", "Ricardo", "Edmund", "Dwight", "Robin", "Dana", "Rudy", "Jon", "Donnie"
            , "Gerardo", "Jeremiah", "Eduardo", "Pablo", "Angel", "Manuel", "Alfonso", "Leo", "Damon", "Bill", "Allen", "Perry", "Rickey", "Benny"
            , "Leroy", "Theodore", "Gordon", "Pedro", "Willard", "Greg", "Rex", "Isaac", "Clifford", "Andre", "Titus", "Levi", "Elijah", "Travis"
            , "Ernesto", "Calvin", "Trevor", "Darren", "Gavin", "Caleb", "Henry", "Donald", "Allen", "Felix", "Shawn", "Arturo", "Ramon", "Gregorio"
            , "Leo", "Tomas", "Andy", "Franklin", "Dwayne", "Terrance", "Terrence", "Nick", "Hector", "Armando", "Jorge", "Arnold", "Cesar", "Dean"
            , "Colin", "Micheal", "Juan", "Lloyd", "Logan", "Phillip", "Garry", "Tom", "Enrique", "Kurt", "Tracy", "Adrian", "Nathaniel", "Ricardo"
            , "Edmund", "Dwight", "Robin", "Dana", "Rudy", "Jon", "Donnie", "Gerardo", "Jeremiah", "Eduardo", "Pablo", "Angel", "Manuel", "Alfonso"
            , "Leo", "Damon", "Bill", "Allen", "Perry", "Rickey", "Benny", "Leroy", "Theodore", "Gordon", "Pedro", "Willard", "Greg", "Rex", "Isaac"
            , "Clifford", "Andre", "Titus", "Levi", "Elijah", "Travis", "Ernesto", "Calvin", "Trevor", "Darren", "Gavin", "Caleb", "Henry", "Donald"
            , "Allen", "Felix", "Shawn", "Arturo", "Ramon", "Gregorio", "Leo", "Tomas", "Andy", "Franklin", "Dwayne", "Terrance", "Terrence", "Nick"
            , "Hector", "Armando", "Jorge", "Arnold", "Cesar", "Dean", "Colin", "Micheal", "Juan", "Lloyd", "Logan", "Phillip", "Garry", "Tom", "Enrique"
            , "Kurt", "Tracy", "Adrian", "Nathaniel", "Ricardo", "Edmund", "Dwight", "Robin", "Dana", "Rudy", "Jon", "Donnie", "Gerardo", "Jeremiah", "Eduardo"
            , "Pablo", "Angel", "Manuel", "Alfonso", "Leo", "Damon", "Bill", "Allen", "Perry", "Rickey", "Benny", "Leroy", "Theodore", "Gordon", "Pedro", "Willard"
            , "Greg", "Rex", "Isaac", "Clifford", "Andre", "Titus", "Levi", "Elijah", "Travis"};
    private static final String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"
            , "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young"
            , "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips"
            , "Campbell", "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey", "Rivera", "Cooper", "Richardson"
            , "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James", "Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennett", "Wood", "Barnes", "Ross", "Henderson", "Coleman"
            , "Jenkins", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons", "Foster", "Gonzales", "Bryant", "Alexander", "Russell", "Griffin", "Diaz", "Hayes"
            , "Myers", "Ford", "Hamilton", "Graham", "Sullivan", "Wallace", "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis", "Harrison", "Gibson", "Mcdonald", "Cruz", "Marshall"
            , "Ortiz", "Gomez", "Murray", "Freeman", "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter", "Hicks", "Crawford", "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren", "Dixon"
            , "Ramos", "Reyes", "Burns", "Gordon", "Shaw", "Holmes", "Rice", "Robertson", "Hunt", "Black", "Daniels", "Palmer", "Mills", "Nichols", "Grant", "Knight", "Ferguson", "Rose", "Stone", "Hawkins", "Dunn"
            , "Perkins", "Hudson", "Spencer", "Gardner", "Stephens", "Payne", "Pierce", "Berry", "Matthews", "Arnold", "Wagner", "Willis", "Ray", "Watkins", "Olson", "Carroll", "Duncan", "Snyder", "Hart", "Cunningham"
            , "Bradley", "Lane", "Andrews", "Ruiz", "Harper", "Fox", "Riley", "Armstrong", "Carpenter", "Weaver", "Greene", "Lawrence", "Elliott", "Chavez", "Sims", "Austin", "Peters", "Kelley", "Franklin", "Lawson"};

    public static String generateName(){
        Random random = new Random();
        String randomName = firstNames[random.nextInt(firstNames.length)];
        return randomName;
    }

    public static String generateLastName(){
        Random random = new Random();
        String randomName = lastNames[random.nextInt(lastNames.length)];
        return randomName;
    }



}
