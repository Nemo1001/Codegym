package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[][] map = {
                {"*"}
        };

        System.out.print("*");
        String[][] map = {
                {"*", "."}
        };

        for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
            if (map[0][xOrdinate].equals("*")) System.out.print("*");
            else System.out.print(1);
        }
        String[][] map = {
                {"*", "."}
        };

        final int MAP_WIDTH = map[0].length;

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String curentCell = map[0][xOrdinate];
            if (curentCell.equals("*")) System.out.print("*");
            else System.out.print(1);
        }
        String[][] map = {
                {"*", "."}
        };

        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[1][MAP_WIDTH];
        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String curentCell = map[0][xOrdinate];
            if (curentCell.equals("*")) mapReport[0][xOrdinate] = "*";
            else mapReport[0][xOrdinate] = "1";
        }

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String currentCellReport = mapReport[0][xOrdinate];
            System.out.print(currentCellReport);
        }
        String[][] map = {
                {"*", ".", "*", ".", "."}
        };

        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[1][MAP_WIDTH];
        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String curentCell = map[0][xOrdinate];
            if (curentCell.equals("*")) {
                mapReport[0][xOrdinate] = "*";
            } else {
                int minesAround = 0;

                boolean hasNeighbourAtLeft = xOrdinate - 1 >= 0;
                boolean hasMineAtLeft = hasNeighbourAtLeft && map[0][xOrdinate - 1].equals("*");
                if (hasMineAtLeft) minesAround++;

                boolean hasNeighbourAtRight = xOrdinate + 1 < MAP_WIDTH;
                boolean hasMineAtRight = hasNeighbourAtRight && map[0][xOrdinate + 1].equals("*");
                if (hasMineAtRight) minesAround++;

                mapReport[0][xOrdinate] = String.valueOf(minesAround);
            }
        }

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String currentCellReport = mapReport[0][xOrdinate];
            System.out.print(currentCellReport);
        }
        String[][] map = {
                {"*", ".", "*", ".", "."}
        };

        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[1][MAP_WIDTH];
        for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
            String curentCell = map[0][xOrdinate];
            if (curentCell.equals("*")) {
                mapReport[0][xOrdinate] = "*";
            } else {
                final int[][] NEIGHBOURS_ORDINATE = {
                        {0, xOrdinate - 1}, {0, xOrdinate + 1}
                };

                int minesAround = 0;
                for (int i = 0; i < NEIGHBOURS_ORDINATE.length; i++) {
                    int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                    int xOrdinateOfNeighbour = neighbourOrdinate[1];
                    int yOrdinateOfNeighbour = neighbourOrdinate[0];

                    boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0 || xOrdinateOfNeighbour == MAP_WIDTH;
                    if (isOutOfMapNeighbour) continue;

                    boolean isMineOwnerNeighbour = map[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                    if (isMineOwnerNeighbour) minesAround++;
                }

                mapReport[0][xOrdinate] = String.valueOf(minesAround);
            }
        }

        for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
            String currentCellReport = mapReport[0][xOrdinate];
            System.out.print(currentCellReport);
        }
        String[][] map = {
                {"*", ".", "*", ".", "."},
                {".", "*", ".", ".", "."}
        };
        final int MAP_HEIGHT = map.length;
        final int MAP_WIDTH = map[0].length;

        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        String[][] mapReport = new String[MAP_HEIGHT][MAP_WIDTH];
        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < map[0].length; xOrdinate++) {
                String curentCell = map[yOrdinate][xOrdinate];
                if (curentCell.equals("*")) {
                    mapReport[yOrdinate][xOrdinate] = "*";
                } else {
                    final int[][] NEIGHBOURS_ORDINATE = {
                            {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1}
                    };

                    int minesAround = 0;
                    for (int i = 0; i < NEIGHBOURS_ORDINATE.length; i++) {
                        int[] neighbourOrdinate = NEIGHBOURS_ORDINATE[i];
                        int xOrdinateOfNeighbour = neighbourOrdinate[1];
                        int yOrdinateOfNeighbour = neighbourOrdinate[0];

                        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0 || xOrdinateOfNeighbour == MAP_WIDTH;
                        if (isOutOfMapNeighbour) continue;

                        boolean isMineOwnerNeighbour = map[yOrdinateOfNeighbour][xOrdinateOfNeighbour].equals("*");
                        if (isMineOwnerNeighbour) minesAround++;
                    }

                    mapReport[yOrdinate][xOrdinate] = String.valueOf(minesAround);
                }
            }
        }
        for (int yOrdinate = 0; yOrdinate < MAP_HEIGHT; yOrdinate++) {
            for (int xOrdinate = 0; xOrdinate < MAP_WIDTH; xOrdinate++) {
                String currentCellReport = mapReport[yOrdinate][xOrdinate];
                System.out.print(currentCellReport);
            }
        }
        final int[][] NEIGHBOURS_ORDINATE = {
                {yOrdinate - 1, xOrdinate - 1}, {yOrdinate - 1, xOrdinate}, {yOrdinate - 1, xOrdinate + 1},
                {yOrdinate, xOrdinate - 1}, {yOrdinate, xOrdinate + 1},
                {yOrdinate + 1, xOrdinate - 1}, {yOrdinate + 1, xOrdinate}, {yOrdinate + 1, xOrdinate + 1},
        };
        boolean isOutOfMapNeighbour = xOrdinateOfNeighbour < 0
                || xOrdinateOfNeighbour == MAP_WIDTH
                || yOrdinateOfNeighbour < 0
                || yOrdinateOfNeighbour == MAP_HEIGHT;
        if (isOutOfMapNeighbour) continue;
    }
}
