
package pl.vertty.arivi.managers.comparator;

import pl.vertty.arivi.objects.guild.Guild;
import java.util.Comparator;

public class GuildComparator implements Comparator<Guild>
{
    @Override
    public int compare(final Guild g0, final Guild g1) {
        final Integer p0 = g0.getPoints();
        final Integer p2 = g1.getPoints();
        return p2.compareTo(p0);
    }
}
