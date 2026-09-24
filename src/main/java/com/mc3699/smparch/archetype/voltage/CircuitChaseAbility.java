package com.mc3699.smparch.archetype.voltage;

import kotlin.Unit;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.mc3699.provenance.util.ProvScheduler;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.entity.circuit.CircuitEntity;
import net.thebrokenscript.registry.TBSEntities;

import java.util.Iterator;

public class CircuitChaseAbility extends BaseAbility {
    public static final CircuitChaseAbility INSTANCE = new CircuitChaseAbility();
    protected CircuitEntity summonedCircuit = null;
    
    @Override
    public float getUseCost() {
        return 0;
    }
    
    @Override
    public int getCooldown() {
        return 0;
    }
    
    @Override
    public Component getName() {
        return Component.literal("Circuit Chase (Very Janky)");
    }
    
    @Override
    public ResourceLocation getIcon() {
        return ResourceLocation.fromNamespaceAndPath("thebrokenscript","textures/screens/textvhs1.png");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        ServerLevel level = player.serverLevel();
        Vec3 playerPos = player.position();
//        BlockPos spawnPos = player.blockPosition().below();
        
        CircuitEntity circuit = TBSEntities.CIRCUIT.invoke().create(level);
        if (circuit != null) {
            circuit.moveTo(playerPos);

//                circuit.finalizeSpawn(level,
//                        level.getCurrentDifficultyAt(circuit.blockPosition()),
//                        MobSpawnType.TRIGGERED, null);
            circuit.getAttribute(Attributes.SCALE).setBaseValue(0.0);
            circuit.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(0.0);
            circuit.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0);
            circuit.getAttribute(Attributes.FOLLOW_RANGE).setBaseValue(1024.0);
            
            circuit.setNoGravity(true);
            circuit.setInvulnerable(true);
            circuit.setInvisible(true);
//            circuit.noPhysics = true;
//            player.getPersistentData().put("Passengers", circuit.getPersistentData());
//            player.positionRider(circuit);

//                MobEffectInstance invisibilityEffect = new MobEffectInstance(MobEffects.INVISIBILITY, -1, 1, true, false, false);
//            circuit.forceAddEffect(invisibilityEffect, circuit);
            circuit.setGrace(0);
//                circuit.addEffect(invisibilityEffect);
            circuit.setPersistenceRequired();
            
            level.addFreshEntity(circuit);
            
            summonedCircuit = circuit;
        }
        
    }
    @Override
    public void backgroundTick(ServerPlayer serverPlayer) {
        if (summonedCircuit == null || !summonedCircuit.isAlive()) return;
        if (serverPlayer == null || serverPlayer.gameMode.getGameModeForPlayer().equals(GameType.SPECTATOR)) {
            chaseEnd();
            return;
        }
//        summonedCircuit.noPhysics = true;

//        summonedCircuit.startRiding(serverPlayer, true);
        summonedCircuit.teleportTo(serverPlayer.position().x(), serverPlayer.getHitbox().maxY + 0.04, serverPlayer.position().z());
//        summonedCircuit.moveTo(PositionUtil.withY(serverPlayer.position(), 320));
//        ServerLevel level = serverPlayer.serverLevel();
//        if (level.getGameTime() % 5 == 0) {
//            BlockPos spawnPos = serverPlayer.blockPosition().below();
//            summonedCircuit.moveTo(serverPlayer.position());
//
//        }
    }
    
    public void chaseEnd() {
        if (summonedCircuit == null || !summonedCircuit.isAlive()) return;
        summonedCircuit.remove(Entity.RemovalReason.DISCARDED);
        summonedCircuit = null;
    }
    
    
    @Override
    public boolean canExecute(ServerPlayer player) {
        return summonedCircuit == null;
    }
    
}
