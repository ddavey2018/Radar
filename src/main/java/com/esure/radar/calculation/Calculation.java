package com.esure.radar.calculation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esure.radar.calculation.steps.Step;
import com.esure.radar.fields.Field;

public class Calculation
{
    private Map<String, Field<?>> inputParameters = new HashMap<String, Field<?>>();
    private Map<String, Field<?>> globalVariables = new HashMap<String, Field<?>>();
    private Map<String, Field<?>> localVariables = new HashMap<String, Field<?>>();
    private Map<String, Field<?>> variables = new HashMap<String, Field<?>>();
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
