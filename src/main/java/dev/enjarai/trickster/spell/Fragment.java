package dev.enjarai.trickster.spell;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import dev.enjarai.trickster.spell.fragment.BooleanFragment;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.tricks.blunder.BlunderException;
import io.wispforest.endec.Endec;
import io.wispforest.owo.serialization.CodecUtils;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public interface Fragment {
    Supplier<MapCodec<Fragment>> CODEC = Suppliers.memoize(() -> FragmentType.REGISTRY.getCodec().dispatchMap(Fragment::type, FragmentType::codec));
    Supplier<Endec<Fragment>> ENDEC = Suppliers.memoize(() -> CodecUtils.toEndec(CODEC.get().codec()));

    FragmentType<?> type();

    Text asText();

    BooleanFragment asBoolean();

    default Fragment activateAsGlyph(SpellContext ctx, List<Optional<Fragment>> fragments) throws BlunderException {
        return this;
    }

    default boolean isEphemeral() {
        return false;
    }
}
