class PhaseOMatic {
    public static void main(String[] args) {
        String[] wordListOne = {"agnostic", "opinionated", "voice activated", "haptically driven", "extensible",
                "reactive", "agent based", "functional", "AI enabled", "strongly typed"};
        String[] wordListTwo = {"loosely coupled", "six sigma", "asynchronous", "event driven", "pub-sub",
                "IoT", "cloud native", "service oriented", "containerized", "serverless", "microservices", "distributed ledger"};
        String[] wordListThree = {"framework", "library", "DSL", "repository", "pipeline", "service", "mesh",
                "architecture", "perspective", "design", "orientation"};

        int oneLength = wordListOne.length;
        System.out.println(oneLength);
        int twoLength = wordListTwo.length;
        System.out.println(twoLength);
        int threeLength = wordListThree.length;
        System.out.println(threeLength);

        java.util.Random randomGenerator = new java.util.Random();      //what is java.util.Random calling?

        int rand1 = randomGenerator.nextInt(oneLength);
        int rand2 = randomGenerator.nextInt(twoLength);
        int rand3 = randomGenerator.nextInt(threeLength);

        String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];

        System.out.println("What we need is a " + phrase +".");
    }
}