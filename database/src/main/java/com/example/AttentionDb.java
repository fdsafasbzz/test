package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class AttentionDb {
    public static void main(String[] args){
    Schema schama = new Schema(1,"com.sixgod.dllo.anews.db");
        Entity entity = schama.addEntity("Attention");
        entity.addIdProperty().autoincrement();
        entity.addStringProperty("url");
        entity.addStringProperty("title");
        try {
          new DaoGenerator().generateAll(schama,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
