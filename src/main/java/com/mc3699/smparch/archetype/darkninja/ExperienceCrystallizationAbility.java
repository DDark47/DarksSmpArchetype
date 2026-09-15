package com.mc3699.smparch.archetype.darkninja;

import net.mc3699.provenance.ProvenanceDataHandler;
import net.mc3699.provenance.ability.foundation.BaseAbility;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.neoforged.fml.ModList;

import java.util.List;

public class ExperienceCrystallizationAbility extends BaseAbility {
    @Override
    public float getUseCost() { return 3; }
    
    @Override
    public int getCooldown() { return 20; }
    
    @Override
    public Component getName() {
        return Component.literal("Experience Crystallization");
    }
    
    public ResourceLocation getIcon() {
        if (ModList.get().isLoaded("create")) {
            return ResourceLocation.fromNamespaceAndPath("create", "textures/item/experience_nugget.png");
        } else {
            return ResourceLocation.fromNamespaceAndPath("minecraft", "textures/item/barrier.png");
        }
    }
    
    @Override
    public boolean canExecute(ServerPlayer serverPlayer) {
        return ModList.get().isLoaded("create");
    }
    
    @Override
    public void execute(ServerPlayer player) {
        super.execute(player);
        
        ServerLevel level = player.serverLevel();
        
        AABB searchArea = new AABB(player.getBlockPosBelowThatAffectsMyMovement()).inflate(16);
        List<ExperienceOrb> orbs = level.getEntitiesOfClass(ExperienceOrb.class, searchArea);
        if (!orbs.isEmpty()) {
            orbs.forEach(o -> {
                int value = getValue(o);
                
                Item itemIdentity = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", "experience_nugget"));
                ItemStack item = new ItemStack(itemIdentity, value);
                o.spawnAtLocation(item);
                o.remove(Entity.RemovalReason.DISCARDED);
                level.playSound(null, o.getX(), o.getY(), o.getZ(), SoundEvents.AMETHYST_CLUSTER_BREAK, SoundSource.NEUTRAL);
            });
        } else {
            ProvenanceDataHandler.changeAP(player, 3);
        }
    }
    // increasing the output nugget count by 1 every 3 experience, because 1 nugget = 3 experience. I spent annoyingly long making sure this was exploit-proof :/
    private static int getValue(ExperienceOrb orb) {
        int output = 1;
        for (int i = 3; i < orb.value-2; i+=3) {
            output++;
        }
        return output;
    }
}
