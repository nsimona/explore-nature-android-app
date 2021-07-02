package com.example.naturalwonders;

import android.content.Context;

import java.util.ArrayList;


public class DataCollection {
    private static WonderGroup smolyan;
    private static WonderGroup plovdiv;
    private static WonderGroup sofia;
    private static WonderGroup blagoevgrad;
    private static WonderGroup kustendil;

    private static int[] colors = {0xFF00ACC1, 0xFF00897B, 0xFF43A047, 0xFF7CB342, 0xFFC0CA33};

    public static ArrayList<WonderGroup> getFullAttractionsList(Context context) {
        //SMOLYAN
        Wonder snezhanka = new Wonder(getStringData(context, "snezhankaName"), getDrawableData(context, "smolyan_snezhanka"), getStringData(context, "snezhankaDescr"), getStringArrayData(context, "snezhankaCoor"));
        Wonder dyavolskoGyrlo = new Wonder(getStringData(context, "dyavolskoGyrloName"), getDrawableData(context, "dyavolsko_gyrlo"), getStringData(context, "dyavolskoGyrloDescr"), getStringArrayData(context, "dyavolskoGyrloCoor"));
        Wonder chudniteMostove = new Wonder(getStringData(context, "chudniteMostoveName"), getDrawableData(context, "chudnite_mostove"), getStringData(context, "chudniteMostoveDescr"),getStringArrayData(context, "chudniteMostoveCoor"));
        ArrayList<Wonder> smolyanAttr = new ArrayList<Wonder>();
        smolyanAttr.add(snezhanka);
        smolyanAttr.add(dyavolskoGyrlo);
        smolyanAttr.add(chudniteMostove);

        // PLOVDIV
        Wonder vrahBotev = new Wonder(getStringData(context, "vrahBotevName"), getDrawableData(context, "vrah_botev"), getStringData(context, "vrahBotevDescr"), getStringArrayData(context, "vrahBotevCoor"));
        Wonder plochata = new Wonder(getStringData(context, "plochataName"), getDrawableData(context, "plochata"), getStringData(context, "plochataDescr"), getStringArrayData(context, "plochataCoor"));
        ArrayList<Wonder> plovdivAttr = new ArrayList<>();
        plovdivAttr.add(vrahBotev);
        plovdivAttr.add(plochata);

        //SOFIA
        Wonder cherniVrah = new Wonder(getStringData(context, "cherniVrahName"), getDrawableData(context, "cherni_vrah"), getStringData(context, "cherniVrahDescr"), getStringArrayData(context, "cherniVrahCoor"));
        ArrayList<Wonder> sofiaAttr = new ArrayList<>();
        sofiaAttr.add(cherniVrah);

        //BLAGOEVRAGD
        Wonder vihren = new Wonder(getStringData(context, "vihrenName"), getDrawableData(context, "vihren"), getStringData(context, "vihrenDescr"), getStringArrayData(context, "vihrenCoor"));
        ArrayList<Wonder> blagoevgradAttr = new ArrayList<>();
        blagoevgradAttr.add(vihren);

        //KUSTENDIL
        Wonder ruen = new Wonder(getStringData(context, "ruenName"), getDrawableData(context, "ruen"), getStringData(context, "ruenDescr"), getStringArrayData(context, "ruenCoor"));
        Wonder rilskiEzera = new Wonder(getStringData(context, "rilskiEzeraName"), getDrawableData(context, "rilski_ezera"), getStringData(context, "rilskiEzeraDescr"), getStringArrayData(context, "rilskiEzeraCoor"));
        ArrayList<Wonder> kustendilAttr = new ArrayList<>();
        kustendilAttr.add(ruen);
        kustendilAttr.add(rilskiEzera);


        smolyan = new WonderGroup(getStringData(context, "smolyanArea"), smolyanAttr, colors[0]);
        plovdiv = new WonderGroup(getStringData(context, "plovdivArea"), plovdivAttr, colors[1]);
        sofia = new WonderGroup(getStringData(context, "sofiaArea"), sofiaAttr, colors[2]);
        blagoevgrad = new WonderGroup(getStringData(context, "blagoevgradArea"), blagoevgradAttr, colors[3]);
        kustendil = new WonderGroup(getStringData(context, "kustendilArea"), kustendilAttr, colors[4]);

       ArrayList<WonderGroup> wonderGroups = new ArrayList<>();
       wonderGroups.add(smolyan);
       wonderGroups.add(plovdiv);
       wonderGroups.add(sofia);
       wonderGroups.add(blagoevgrad);
       wonderGroups.add(kustendil);

       return wonderGroups;
    }

    private static String getStringData(Context context, String name) {
        int id = context.getResources().getIdentifier(name, "string", context.getPackageName());
        return context.getResources().getString(id);
    }

    private static int getDrawableData(Context context, String name) {
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }
    private static String[] getStringArrayData(Context context, String name) {
        int id = context.getResources().getIdentifier(name, "array", context.getPackageName());
        return context.getResources().getStringArray(id);
    }
}
