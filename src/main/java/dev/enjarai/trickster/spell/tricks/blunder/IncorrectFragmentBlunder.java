package dev.enjarai.trickster.spell.tricks.blunder;

import dev.enjarai.trickster.Trickster;
import dev.enjarai.trickster.spell.Fragment;
import dev.enjarai.trickster.spell.fragment.FragmentType;
import dev.enjarai.trickster.spell.tricks.Trick;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

public class IncorrectFragmentBlunder extends TrickBlunderException {
    public final int index;
    public final Text expectedType;
    public final Fragment found;

    public IncorrectFragmentBlunder(Trick source, int index, Text expectedType, Fragment found) {
        super(source);
        this.index = index;
        this.expectedType = expectedType;
        this.found = found;
    }

    @Override
    public MutableText createMessage() {
        return source.getName().append(": ").append(Text.translatable(
                Trickster.MOD_ID + ".blunder.incorrect_fragment", index, expectedType, found.asText()));
    }
}
