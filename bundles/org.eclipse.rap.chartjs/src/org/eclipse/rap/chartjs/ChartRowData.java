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

import static org.eclipse.rap.chartjs.ChartStyle.asCss;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.rap.json.JsonArray;
import org.eclipse.rap.json.JsonObject;


public class ChartRowData {

  private final String[] labels;
  private final List<Number[]> rows = new ArrayList<Number[]>( 1 );
  private final List<ChartStyle> colors = new ArrayList<ChartStyle>( 1 );

  public ChartRowData( String[] labels ) {
    this.labels = labels;
  }

  public ChartRowData addRow( Number[] row, ChartStyle colors ) {
    rows.add( row );
    this.colors.add( colors );
    return this;
  }

  JsonObject toJson() {
    JsonObject result = new JsonObject();
    result.add( "labels" , asJson( labels ) );
    JsonArray rowsJson = new JsonArray();
    for( int i = 0; i < rows.size(); i++ ) {
      ChartStyle rowColors = colors.get( i );
      rowsJson.add( new JsonObject()
        .add( "fillColor", asCss( rowColors.getFillColor(), rowColors.getFillOpacity() ) )
        .add( "strokeColor", asCss( rowColors.getStrokeColor() ) )
        .add( "pointColor", asCss( rowColors.getPointColor() ) )
        .add( "pointStrokeColor", asCss( rowColors.getPointStrokeColor() ) )
        .add( "data", asJson( rows.get( i ) ) )
      );
    }
    result.add( "datasets", rowsJson );
    return result;
  }

  private JsonArray asJson( String... strings ) {
    JsonArray result = new JsonArray();
    for( int i = 0; i < strings.length; i++ ) {
      result.add( strings[ i ] );
    }
    return result;
  }

  private JsonArray asJson( Number... numbers ) {
    JsonArray result = new JsonArray();
    for( int i = 0; i < numbers.length; i++ ) {
      Number number = numbers[ i ];
      result.add( number instanceof Double ? (Double) number : number instanceof Integer ? (Integer) number : number.intValue() );
    }
    return result;
  }

}
