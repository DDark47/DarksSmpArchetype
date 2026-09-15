package com.mc3699.smparch.archetype.voltage;

import com.mc3699.smparch.SMPArch;
import com.mc3699.smparch.archetype.miku.AidFromBelowAbility;
import kotlin.Unit;
import net.mc3699.provenance.ProvenanceDataHandler;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityTypeUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;

import java.util.*;

public class VoltageChaseAbility extends BaseAbility {
    public static List<Player> CHASED_PLAYERS = new ArrayList<>();
    public static final VoltageChaseAbility INSTANCE = new VoltageChaseAbility();
    
    @Override
    public float getUseCost() {
        return 0;
    }
    
    @Override
    public int getCooldown() {
        return 30 * 20;
    }
    
    @Override
    public Component getName() {
        return Component.literal("Voltage Chase");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/block/teeth_end.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        player.setGameMode(GameType.SURVIVAL);
        player.setInvulnerable(true);
        EntityTypeUtil.trySummon(EntityType.LIGHTNING_BOLT, player.serverLevel(), player.blockPosition());
        
        TheBrokenScript.serverWorkQueue.add(20L, ()->{
            player.setInvulnerable(false);
            return Unit.INSTANCE;
        });
        CHASED_PLAYERS.add(player);
    }
    @Override
    public void backgroundTick(ServerPlayer player) {
        super.backgroundTick(player);
        
        ResourceLocation id = ProvenanceDataHandler.getIdForAbility(player, this);
        if (id == null) return;
        
        int cooldown = ProvenanceDataHandler.getCooldown(player, id);
        
        if (cooldown <= 0) return;
        if (CHASED_PLAYERS.isEmpty()) return;
        
        Level level = player.level();
        if (cooldown > 1) {
            List<Player> targets = level.getEntitiesOfClass(Player.class, player.getBoundingBox().inflate(100));
            targets.forEach(target -> {
                target.displayClientMessage(Component.literal("<;✸;>").withStyle(ChatFormatting.BOLD, ChatFormatting.DARK_RED), true);
                if (level.getRandom().nextFloat() > 0.99F) PlayerUtil.trySendOverlay(target,ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/screens/run.png"),2L);
                
                PlayerExt.INSTANCE.updateVars(player, (PlayerVariable) -> {
                    PlayerVariable.setTextGlitchStrength(10);
                    return Unit.INSTANCE;
                });
                
//                if (level.isClientSide()) {
//                    SMPArch.LOGGER.info("DIEDIEDIEDIE");
//                    CircuitEffectsShaker.INSTANCE.setPlayer((LocalPlayer)target);
//                    CircuitEffectsShaker.INSTANCE.setChasingThisPlayer(true);
//                };
                if (!CHASED_PLAYERS.contains(target)) {
                    CHASED_PLAYERS.add(target);
                    SMPArch.LOGGER.debug("chasing player {}", target.getName().getString());
                }
            });
        } else {
            chaseEnd();
            player.setGameMode(GameType.SPECTATOR);
        }
    }
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return !(player.gameMode.getGameModeForPlayer().equals(GameType.SPECTATOR));
    }
    public void chaseEnd() {
        Iterator<Player> itr = CHASED_PLAYERS.iterator();
        while (itr.hasNext()) {
            Player target = itr.next();
            target.displayClientMessage(Component.literal("<✸>").withStyle(ChatFormatting.BOLD, ChatFormatting.BLACK), true);
            PlayerExt.INSTANCE.updateVars(target, (PlayerVariable) -> {
                PlayerVariable.setTextGlitchStrength(0);
                return Unit.INSTANCE;
            });
            itr.remove();
        }
    }
}
