package emiya.dmmod.main;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import emiya.dmmod.config.ConfigManager;
import emiya.dmmod.event.DeathMessageEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

@Mod(modid = DeathMessageMod.MODID, name = DeathMessageMod.NAME, version = DeathMessageMod.VERSION)
public class DeathMessageMod
{
    public static final String MODID = "dmmod";
    public static final String NAME = "Death Message Mod";
    public static final String VERSION = "1.0";
    public static ArrayList<EntityLivingBase> entitiesHitByPlayer = new ArrayList();
    public static ArrayList<EntityPlayer> playerSyncList = new ArrayList();

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigManager.init(event.getModConfigurationDirectory());

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new DeathMessageEvent());
    }
}
