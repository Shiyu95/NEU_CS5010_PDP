package dungeon;
public class MedievalLevelBuilder {
    private final int roomNum;
    private final int monsterNum;
    private final int treasureNum;
    private final Level level;
    private int roomCount = 0;
    private int monsterCount = 0;
    private int treasureCount = 0;

    public MedievalLevelBuilder(int levelNum, int roomNum, int monsterNum, int treasureNum) {
        if (levelNum < 0 || roomNum < 0 || monsterNum < 0 || treasureNum < 0) {
            throw new IllegalArgumentException("those value can't be negative");
        }
        this.roomNum = roomNum;
        this.monsterNum = monsterNum;
        this.treasureNum = treasureNum;
        this.level = new Level(levelNum);
    }

    //add room the level
    public MedievalLevelBuilder addRoom(String description){
        if (roomCount == roomNum) {
            throw new IllegalStateException("It already reach the target room number.");
        }
        level.addRoom(description);
        roomCount++;
        return this;
    }

    //add goblins to specified room
    public MedievalLevelBuilder addGoblins(int targetRoom, int goblinsNum) {
        if (targetRoom < 0 || goblinsNum < 0) {
            throw new IllegalArgumentException("Those parameter can't be negative");
        }
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }
        if (monsterCount + goblinsNum > this.monsterNum) {
            throw new IllegalStateException("Can't add more goblins, it already reach the target monster number");
        }

        for (int i = 0; i < goblinsNum; i++) {
            Monster goblin = new Monster("goblin",
                    "mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind",
                    7);
            level.addMonster(targetRoom, goblin);
            monsterCount++;
        }
        return this;
    }

    //add orc to specified room
    public MedievalLevelBuilder addOrc(int targetRoom) {
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }
        if (monsterCount == this.monsterNum) {
            throw new IllegalStateException("The target number of monsters has already been reached.");
        }

        Monster orc = new Monster("orc", "brutish, aggressive, malevolent being serving evil", 20);
        level.addMonster(targetRoom, orc);
        monsterCount++;
        return this;
    }


    //add ogre to specified room
    public MedievalLevelBuilder addOgre(int targetRoom) {
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }

        if (monsterCount == this.monsterNum) {
            throw new IllegalStateException("The target number of monsters has already been reached.");
        }

        Monster ogre = new Monster( "ogre",
                "large, hideous man-like being that likes to eat humans for lunch", 50);
        level.addMonster(targetRoom, ogre);
        monsterCount++;

        return this;
    }


    //add human to specified room
    public MedievalLevelBuilder addHuman(int targetRoom, String name, String description,
                                         final int hitPoints) {
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }
        if (monsterCount == this.monsterNum) {
            throw new IllegalStateException("The target number of monsters has already been reached.");
        }
        Monster human = new Monster(name, description, hitPoints);
        level.addMonster(targetRoom,human);
        monsterCount++;

        return this;
    }


    //add potion treasure to specified room
    public MedievalLevelBuilder addPotion(int targetRoom) {
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }

        if (treasureCount == this.treasureNum) {
            throw new IllegalStateException("The largest limit treasure number already reach");
        }

        Treasure potion = new Treasure("a healing potion",1);
        level.addTreasure(targetRoom,potion);
        treasureCount++;

        return this;
    }

    //add gold treasure to specified room
    public MedievalLevelBuilder addGold(int targetRoom, int goldValue) {
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }

        if (treasureCount == this.treasureNum) {
            throw new IllegalStateException("The largest limit treasure number already reach");
        }

        Treasure gold = new Treasure("pieces of gold", goldValue);
        level.addTreasure(targetRoom,gold);
        treasureCount++;

        return this;
    }


    //add weapon treasure to specified room
    public MedievalLevelBuilder addWeapon(int targetRoom, String weaponDescription) {
        if (targetRoom < 0) {
            throw new IllegalArgumentException(" Negative arguments not allowed");
        }
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }

        if (treasureCount == this.treasureNum) {
            throw new IllegalStateException("The largest limit treasure number already reach");
        }

        Treasure weapon = new Treasure(weaponDescription, 10);
        level.addTreasure(targetRoom,weapon);
        treasureCount++;

        return this;
    }


    //add special treasure to specified room
    public MedievalLevelBuilder addSpecial(int targetRoom, String specialDescription, int specialValue) {
        if (targetRoom < 0) {
            throw new IllegalArgumentException("It can't be negative");
        }
        if (targetRoom + 1 > roomCount) {
            throw  new IllegalArgumentException("The target room has not yet been created");
        }
        if (treasureCount == this.treasureNum) {
            throw new IllegalStateException("The largest limit treasure number already reach.");
        }
        Treasure special = new Treasure(specialDescription, specialValue);
        level.addTreasure(targetRoom, special);
        treasureCount++;
        return this;

    }

    public Level build() throws IllegalStateException {
        if (roomCount != roomNum || monsterCount != monsterNum || treasureCount != treasureNum) {
            throw new IllegalStateException("It is called before completion");
        }
        return level;
    }

}