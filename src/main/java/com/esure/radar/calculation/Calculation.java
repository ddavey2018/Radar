package com.esure.radar.calculation;

import java.util.ArrayList;
import java.util.List;

import com.esure.radar.calculation.steps.Step;

public class Calculation
{

    private List<Step> steps = new ArrayList<Step>();

    public void addStep(Step step)
    {
        steps.add(step);
    }

    public void calculate()
    {
        for (Step step : steps)
        {
            step.execute();
        }
    }
}
