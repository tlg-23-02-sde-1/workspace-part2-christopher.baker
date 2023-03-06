class BottlesOfBeer {
    public static void main(String[] args) {
        int bottlesOfBeer = 99;
        String bottles = " bottles ";

        while (bottlesOfBeer>0) {
            if (bottlesOfBeer == 1) {
                bottles = " bottle ";
            }
            System.out.println(bottlesOfBeer + bottles + "of beer on the wall");
            System.out.println(bottlesOfBeer + bottles + "of beer");
            System.out.println("Take one down and pass it around");
            bottlesOfBeer = bottlesOfBeer - 1;
            if (bottlesOfBeer > 0) {
                System.out.println(bottlesOfBeer + bottles + "of beer on the wall");
            } else {
                System.out.println("There'll be no more bottles of beer on the wall");
            }
        }
    }
}