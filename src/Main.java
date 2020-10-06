public class Main {

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception E) {
            System.out.println(E);
        }
    }

    static void showArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(array[i][j] + "\t");
                }
            }
            System.out.println();
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        cls();
    }

    static int[][] changeTo(int[][] array) {
        try {
            for (int iGlobal = 0; iGlobal < array.length; iGlobal++) {
                for (int jGlobal = 0; jGlobal < array.length; jGlobal++) {
                    if (array[iGlobal][jGlobal] == 1) {

                        int waveCounter = 3;
                        int i = iGlobal;
                        int j = jGlobal;
                        showArray(array);
                        array[iGlobal][jGlobal] = 0;

                        while (i >= 0 && j >= 0) {
                            i--;
                            j--;
                            for (int k = 0; k < waveCounter; j++, k++) {
                                array[i][j] = 1;
                            }
                            j--;
                            for (int k = 0; k < waveCounter; i++, k++) {
                                array[i][j] = 1;
                            }
                            i--;
                            for (int k = 0; k < waveCounter; j--, k++) {
                                array[i][j] = 1;
                            }
                            j++;
                            for (int k = 0; k < waveCounter; i--, k++) {
                                array[i][j] = 1;
                            }
                            i++;

                            showArray(array);

                            for (int a = 0; a < array.length; a++) {
                                for (int b = 0; b < array.length; b++) {
                                    array[a][b] = 0;
                                }
                            }
                            waveCounter += 2;
                        }
                        iGlobal = array.length;
                        jGlobal = array.length;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You don't right man, therefore I give you " + e.getMessage());
        } finally {
            showArray(array);
        }
        return array;
    }

    public static void main(String[] args) {

        int[][] array = new int[33][33];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = 0;
            }
        }

        cls();

        for (int i = 0; i < 100; i++) {
            array[array.length / 2][array.length / 2] = 1;
            changeTo(array);
        }
    }
}