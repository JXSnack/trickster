package dev.enjarai.trickster.cca;

import dev.enjarai.trickster.Trickster;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class ModCumponents implements EntityComponentInitializer {
    public static final ComponentKey<DisguiseCumponent> DISGUISE =
            ComponentRegistry.getOrCreate(Trickster.id("disguise"), DisguiseCumponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(DISGUISE, DisguiseCumponent::new, RespawnCopyStrategy.LOSSLESS_ONLY);
    }
}
