package emiya.dmmod.config;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigManager
{
    public static String DM1;
    public static String DM2;
    public static String DM3;
    public static String DM4;
    public static String DM5;
    public static String DM6;
    public static String DM7;
    public static String DM8;
    public static String DM9;
    public static String DM10;
    public static String BM1;
    public static String BM2;
    public static String BM3;
    public static String BM4;
    public static String BM5;
    public static String EM1;
    public static String EM2;
    public static String EM3;
    public static String EM4;
    public static String EM5;
    public static String FM1;
    public static String FM2;
    public static String FM3;
    public static String FM4;
    public static String FM5;
    public static String EXM1;
    public static String EXM2;
    public static String EXM3;
    public static String EXM4;
    public static String EXM5;
    public static String FAM1;
    public static String FAM2;
    public static String FAM3;
    public static String FAM4;
    public static String FAM5;
    public static String VM1;
    public static String VM2;
    public static String VM3;
    public static String VM4;
    public static String VM5;
    public static ArrayList<String> deathMessages = new ArrayList();
    public static ArrayList<String> bowDeathMessages = new ArrayList();
    public static ArrayList<String> projectileDeathMessages = new ArrayList();
    public static ArrayList<String> fireDeathMessages = new ArrayList();
    public static ArrayList<String> explosionDeathMessages = new ArrayList();
    public static ArrayList<String> fallDeathMessages = new ArrayList();
    public static ArrayList<String> voidDeathMessages = new ArrayList();
    public static Configuration config;
    public static String DM = "Melee messages";
    public static String BM = "Bow Messages";
    public static String EM = "Projectile (non-bow) Messages";
    public static String FM = "Fire Messages";
    public static String EXM = "Explosion Messages";
    public static String FAM = "Fall Messages";
    public static String VM = "Void Messages";

    public static void init(File path)
    {
        config = new Configuration(new File(path, "MobDeathMessages.cfg"));

        config.load();
        addDeathMessages();
        config.save();
    }

    public static void addDeathMessages()
    {
        config.addCustomCategoryComment(BM, "Create your own custom death messages here! Remember these things:\n\n<mob> will be replaced with the mob's name\n<player> will be replaced with the player's name\nempty means that there is no death message there, and it will not be used.\n\nBow death messages - are used if the enemy is killed by the player's arrow");
        config.addCustomCategoryComment(DM, "Melee death messages - you should know what triggers these");

        DM1 = config.get(DM, "dm1", "<mob> was rekt by <player>").getString();
        DM2 = config.get(DM, "dm2", "<player> absolutely destroyed <mob>").getString();
        DM3 = config.get(DM, "dm3", "<mob> was ripped to shreds by <player>").getString();
        DM4 = config.get(DM, "dm4", "empty").getString();
        DM5 = config.get(DM, "dm5", "empty").getString();
        DM6 = config.get(DM, "dm6", "empty").getString();
        DM7 = config.get(DM, "dm7", "empty").getString();
        DM8 = config.get(DM, "dm8", "empty").getString();
        DM9 = config.get(DM, "dm9", "empty").getString();
        DM10 = config.get(DM, "dm10", "empty").getString();

        BM1 = config.get(BM, "bm1", "<mob> was shot through the heart, <player> is to blame").getString();
        BM2 = config.get(BM, "bm2", "<mob> was SNIPED by <player>").getString();
        BM3 = config.get(BM, "bm3", "<mob> was bowed down by <player>").getString();
        BM4 = config.get(BM, "bm4", "<mob> was no-scoped by <player>").getString();
        BM5 = config.get(BM, "bm5", "empty").getString();

        config.addCustomCategoryComment(EM, "Projectile death messages - are used for ranged attacks that aren't arrows. Nothing in vanilla would fit this, really, but it works with stuff like Advent of Ascension's energy weapons.");
        EM1 = config.get(EM, "em1", "<mob> was beamed hard by <player>").getString();
        EM2 = config.get(EM, "em2", "<mob> was obliterated by <player>'s weapon").getString();
        EM3 = config.get(EM, "em3", "<mob> lost the duel to <player>").getString();
        EM4 = config.get(EM, "em4", "<mob> was pummeled - and pummeled hard - by <player>").getString();
        EM5 = config.get(EM, "em5", "empty").getString();

        config.addCustomCategoryComment(FM, "Fire death messages - are used if the mob dies while on fire if it was previously hit by a player.");
        FM1 = config.get(FM, "fm1", "<mob> is now a pile of ash, courtesy of <player>").getString();
        FM2 = config.get(FM, "fm2", "<mob> thought it had the Fire Resistance effect").getString();
        FM3 = config.get(FM, "fm3", "<mob> was roasted by <player>").getString();
        FM4 = config.get(FM, "fm4", "<player> is now selling <mob> BBQ").getString();
        FM5 = config.get(FM, "fm5", "empty").getString();

        config.addCustomCategoryComment(EXM, "Explosion death messages - these are self-explanatory. Placing TNT and using it counts as you blowing it up.");
        EXM1 = config.get(EXM, "exm1", "<mob> went KAWHOOM because of <player>").getString();
        EXM2 = config.get(EXM, "exm2", "empty").getString();
        EXM3 = config.get(EXM, "exm3", "empty").getString();
        EXM4 = config.get(EXM, "exm4", "empty").getString();
        EXM5 = config.get(EXM, "exm5", "empty").getString();

        config.addCustomCategoryComment(FAM, "Fall death messages - if you throw the mob off a cliff you get this.");
        FAM1 = config.get(FAM, "exm1", "<mob> was thrown off a cliff by <player>").getString();
        FAM2 = config.get(FAM, "exm2", "<mob> smacked the ground way too hard").getString();
        FAM3 = config.get(FAM, "exm3", "empty").getString();
        FAM4 = config.get(FAM, "exm4", "empty").getString();
        FAM5 = config.get(FAM, "exm5", "empty").getString();

        config.addCustomCategoryComment(VM, "Void death messages - good if you have mods that add a dimension filled with void.");
        VM1 = config.get(VM, "vm1", "<mob> fell out of the world").getString();
        VM2 = config.get(VM, "vm2", "<mob> went too far past y = -64.0").getString();
        VM3 = config.get(VM, "vm3", "<player> threw <mob> into the void").getString();
        VM4 = config.get(VM, "vm4", "empty").getString();
        VM5 = config.get(VM, "vm5", "empty").getString();





        String[] dms = { DM1, DM2, DM3, DM4, DM5, DM6, DM7, DM8, DM9, DM10 };
        String[] bms = { BM1, BM2, BM3, BM4, BM5 };
        String[] ems = { EM1, EM2, EM3, EM4, EM5 };
        String[] fms = { FM1, FM2, FM3, FM4, FM5 };
        String[] exms = { EXM1, EXM2, EXM3, EXM4, EXM5 };
        String[] fams = { FAM1, FAM2, FAM3, FAM4, FAM5 };
        String[] vms = { VM1, VM2, VM3, VM4, VM5 };

        addDeathMessages(dms, deathMessages);
        addDeathMessages(bms, bowDeathMessages);
        addDeathMessages(ems, projectileDeathMessages);
        addDeathMessages(fms, fireDeathMessages);
        addDeathMessages(exms, explosionDeathMessages);
        addDeathMessages(fams, fallDeathMessages);
        addDeathMessages(vms, voidDeathMessages);

        System.out.println("NUM VOID DMS: " + voidDeathMessages.size());
    }

    public static void addDeathMessages(String[] potentialMessages, ArrayList<String> finalMessages)
    {
        for (String a : potentialMessages) {
            if ((a != null) && (!a.equals("empty"))) {
                finalMessages.add(a);
            }
        }
    }
}
