package emiya.dmmod.event;

import emiya.dmmod.main.DeathMessageMod;

import emiya.dmmod.manager.DeathMessageManager;

import emiya.dmmod.manager.DeathMessageManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeathMessageEvent
{
    @SubscribeEvent
    public void addDeathMessage(LivingDeathEvent event)
    {
        Entity player = event.getSource().getTrueSource();
        EntityLivingBase mob = event.getEntityLiving();
        DamageSource source = event.getSource();
        if ((mob != null) && (DeathMessageMod.entitiesHitByPlayer.contains(mob)))
        {
            int index = DeathMessageMod.entitiesHitByPlayer.indexOf(mob);
            EntityPlayer castedPlayer = (EntityPlayer)DeathMessageMod.playerSyncList.get(index);

            String mobName = mob.getName();
            String playerName = castedPlayer.getDisplayNameString();
            String deathMessage = DeathMessageManager.createDeathMessage(mobName, playerName, source);

            castedPlayer.sendMessage(new TextComponentString(deathMessage));

            DeathMessageMod.entitiesHitByPlayer.remove(mob);
            DeathMessageMod.playerSyncList.remove(castedPlayer);
        }
    }

    @SubscribeEvent
    public void livingHurt(LivingHurtEvent event)
    {
        Entity player = event.getSource().getTrueSource();
        EntityLivingBase mob = event.getEntityLiving();
        if ((player != null) && ((player instanceof EntityPlayer)))
        {
            EntityPlayer castedPlayer = (EntityPlayer)player;
            if (!DeathMessageMod.entitiesHitByPlayer.contains(mob))
            {
                DeathMessageMod.entitiesHitByPlayer.add(mob);
                DeathMessageMod.playerSyncList.add(castedPlayer);
            }
        }
    }
}
