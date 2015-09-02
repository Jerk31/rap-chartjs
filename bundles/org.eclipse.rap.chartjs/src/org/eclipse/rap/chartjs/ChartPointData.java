/*******************************************************************************
 * Copyright (c) 2015 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 *    jsivadier - update to support all kind of Number and not just integers
 ******************************************************************************/

package org.eclipse.rap.chartjs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rap.json.JsonArray;
import org.eclipse.rap.json.JsonObject;


public class ChartPointData {

  private final List<Number> points = new ArrayList<Number>( 5 );
  private final List<ChartStyle> colors = new ArrayList<ChartStyle>( 5 );

  public ChartPointData addPoint( Number value, ChartStyle chartStyle ) {
    points.add( value );
    colors.add( chartStyle );
    return this;
  }

  JsonArray toJson() {
    JsonArray result = new JsonArray();
    for( int i = 0; i < points.size(); i++ ) {
    	Number n = points.get(i);
      result.add( new JsonObject()
        .add( "value", n instanceof Double ? (Double) n : n instanceof Integer ? (Integer) n : n.intValue() )
        .add( "color", ChartStyle.asCss( colors.get( i ).getFillColor() ) )
      );
    }
    return result;
  }

}
