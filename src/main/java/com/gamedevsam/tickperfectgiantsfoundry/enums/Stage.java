package com.gamedevsam.tickperfectgiantsfoundry.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Stage
{
	HAMMER("Hammer", Heat.HIGH, 20, -25, 4, 14),
	GRIND("Grind", Heat.MED, 10, 15, 7, 19),
	POLISH("Polish", Heat.LOW, 10, -17, 12, 10);

	private final String name;
	private final Heat heat;
	private final int progressPerAction;
	private final int heatChange;

	private final int distanceToLava;
	private final int distanceToWaterfall;

	public boolean isHeating()
	{
		return heatChange > 0;
	}

	public boolean isCooling()
	{
		return heatChange < 0;
	}

}
