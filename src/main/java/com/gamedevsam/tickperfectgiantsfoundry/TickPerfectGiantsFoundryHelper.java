package com.gamedevsam.tickperfectgiantsfoundry;

import lombok.extern.slf4j.Slf4j;
import net.runelite.client.ui.ColorScheme;

import javax.inject.Singleton;
import java.awt.*;

@Slf4j
@Singleton
public final class TickPerfectGiantsFoundryHelper
{


	public static Color getHeatColor(int actions, int heat)
	{
		if (heat >= actions)
		{
			return ColorScheme.PROGRESS_COMPLETE_COLOR;
		}

		if (heat > 0)
		{
			return ColorScheme.PROGRESS_INPROGRESS_COLOR;
		}

		return ColorScheme.PROGRESS_ERROR_COLOR;
	}
}
