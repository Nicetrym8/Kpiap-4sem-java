package com.labs.javalabs.models.cylinder;

import java.util.List;

public record CylinderBulkResponse(StatsMapper stats, List<Cylinder> values) {
}
