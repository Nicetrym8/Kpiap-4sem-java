package com.labs.javalabs.models.cylinder;

import java.util.DoubleSummaryStatistics;

public record StatsMapper(double min, double max, double average) {
    public StatsMapper(DoubleSummaryStatistics stat) {
        this(stat.getMin(), stat.getMax(), stat.getAverage());
    }
}
