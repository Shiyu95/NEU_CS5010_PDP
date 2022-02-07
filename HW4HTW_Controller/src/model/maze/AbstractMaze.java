package model.maze;

import java.util.*;

import model.game.Cell;
import model.game.Game;
import model.game.MonsterType;
import model.game.Player;

abstract class AbstractMaze implements Maze {
    //Variable for the AbstractMaze class
    private final int pitNum;
    private final int batNum;
    private final int totalRow;
    private final int totalCol;
    private final int wallNum;
    private final List<int[]> allEdges;
    private final Cell[][] cell;
    private final List<int[]> pitsLocationList;
    private final List<int[]> batsLocationList;
    private final int totalCells;

    //AbstractMaze constructor
    public AbstractMaze(int col, int row, int remainWalls, int bat, int pit) {
        //The num of row and col shouldn't be negative number
        if (row <= 0 || col <= 0) {
            throw new IllegalArgumentException("The maze should have positive row and columns.");
        }
        //we should check valid remain wall for the maze
        int edgesSize = (row - 1) * col + (col - 1) * row;
        int limitNum = edgesSize - row * col + 1;
        if (remainWalls < 0 || remainWalls > limitNum) {
            throw new IllegalArgumentException("You have an Invalid remaining walls for a room maze.");
        }

        this.totalRow = row;
        this.totalCol = col;
        this.wallNum = remainWalls;
        this.cell = new Cell[row][col];
        this.totalCells = col * row;
        this.batNum = bat;
        this.pitNum = pit;
        this.allEdges = new ArrayList<>();
        this.pitsLocationList = new ArrayList<>();
        this.batsLocationList = new ArrayList<>();

    }

    @Override
    public int getTotalRow() {
        return this.totalRow;
    }

    @Override
    public int getTotalCol() {
        return this.totalCol;
    }

    @Override
    public int getWallNum() {
        return this.wallNum;
    }

    @Override
    public List<int[]> getAllEdges() {
        return this.allEdges;
    }

    @Override
    public Cell[][] getCell() {
        return this.cell;
    }



    @Override
    public void buildMaze(List<int[]> allEdges, boolean isPerfect, int remainWalls) {
        int LocationID = 0;
        //create a two-dimensional array for the cell object
        //set up each cell id and
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                Cell eachCell = new Cell(new int[]{i, j});
                eachCell.setID(LocationID);
                this.cell[i][j] = eachCell;
                LocationID++;
            }
        }

        //set up all inside edges in a maze and put all into the edges list
        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol - 1; j++) {
                this.allEdges.add(new int[]{i, j, i, j + 1});
            }
        }
        for (int j = 0; j < totalCol; j++) {
            for (int i = 0; i < totalRow - 1; i++) {
                this.allEdges.add(new int[]{i, j, i + 1, j});
            }
        }

        Random random = new Random();
        random.setSeed(4);


        List<Set<Integer>> wallSet = new ArrayList<>();
        for (int i = 0; i < totalCells; i++) {
            HashSet<Integer> newSet = new HashSet<>();
            newSet.add(i);
            wallSet.add(newSet);
        }

        //remove wall and put into set
        int count = 0;
        while (totalCells - 1 > count) {
            //random get two cell. check they are in a same set or not
            int[] randomEdges = this.allEdges.get(random.nextInt(this.allEdges.size()));
            Cell cell1 = this.cell[randomEdges[0]][randomEdges[1]];
            Cell cell2 = this.cell[randomEdges[2]][randomEdges[3]];
            HashSet<Integer> setOne = (HashSet<Integer>) wallSet.get(cell1.getID());
            HashSet<Integer> setTwo = (HashSet<Integer>) wallSet.get(cell2.getID());

            // When find distinct sets, remove the edge from edgeList and update the current set.
            if (!(setOne.equals(setTwo))) {
                // add setTwo into setOne
                setOne.addAll(setTwo);
                for (Integer index : setOne) {
                    wallSet.set(index, setOne);
                }
                this.allEdges.remove(randomEdges);
                count++;

                //updating each cell
                if (randomEdges[0] < randomEdges[2] || randomEdges[0] > randomEdges[2]) {
                    cell1.setSouth(cell2);
                    cell2.setNorth(cell1);
                } else {
                    cell1.setEast(cell2);
                    cell2.setWest(cell1);
                }
            }

        }


        //for roomMaze
        if (!isPerfect) {
            while (this.allEdges.size() > remainWalls) {
                //remove edges from savedEdge
                int[] randomEdges = this.allEdges.get(random.nextInt(this.allEdges.size()));
                this.allEdges.remove(randomEdges);

            }
        }
        this.addPit();
        this.addBat();

    }


    @Override
    public void addBat() {
        Random random = new Random();
        random.setSeed(1);
        int numOfBatsCell = batNum;

        HashMap<int[], MonsterType> batCell = new HashMap<>();
        while (batCell.size() < numOfBatsCell) {
            int[] batItem = new int[]{random.nextInt(this.totalRow), random.nextInt(this.totalCol)};
            System.out.println("bat location room:" + Arrays.toString(batItem));
            batCell.put(batItem, MonsterType.BAT);
            batsLocationList.add(batItem);

        }

        for (int[] position : batCell.keySet()) {
            this.cell[position[0]][position[1]].setBat();
        }
    }

    @Override
    public List<int[]> getBatsLoc() {
        return this.batsLocationList;
    }

    @Override
    public void addPit() {
        Random random = new Random();
        random.setSeed(2);

        int numOfPitsCell = pitNum;
        HashMap<int[], MonsterType> pitCell = new HashMap<>();
        while (pitCell.size() < numOfPitsCell) {
            int[] pitItem = new int[]{random.nextInt(this.totalRow), random.nextInt(this.totalCol)};
            System.out.println("pit location room:" + Arrays.toString(pitItem));
            pitCell.put(pitItem, MonsterType.PIT);
            pitsLocationList.add(pitItem);
        }

        for (int[] position : pitCell.keySet()) {
            this.cell[position[0]][position[1]].setPit();
        }
    }

    @Override
    public List<int[]> getPitsLocation() {
        return this.pitsLocationList;
    }

}
