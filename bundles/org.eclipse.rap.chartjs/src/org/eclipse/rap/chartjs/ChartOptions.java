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


import org.eclipse.rap.json.JsonObject;


public class ChartOptions {
	
	private boolean animation = true;
	private boolean showToolTips = true;
	private boolean scaleBeginAtZero = true;
	private boolean bezierCurve = true;
	private boolean showFill = true;
	private boolean scaleShowLabels = true;
	private boolean scaleIntegersOnly = true;
	private boolean responsive = false;
	private int pointDotRadius = 3;
	private int pointHitDetectionRadius = 20;
	private int strokeWidth = 2;
	
	
	/**
	 * Sets whether to play an "appear" animation for a new chart drawing.
	 * @param animation
	 * @return
	 */
	public ChartOptions setAnimation(boolean animation) {
		this.animation = animation;
		return this;
	}
	
	public boolean getAnimation() {
		return this.animation;
	}
	
	/**
	 * Sets whether to show tooltips on data segments/points/bars.
	 *
	 * @param showToolTips
	 * @return
	 */
	public ChartOptions setShowToolTips(boolean showToolTips) {
		this.showToolTips = showToolTips;
		return this;
	}
	
	public boolean getShowToolTips() {
		return this.showToolTips;
	}
	
	public boolean getScaleBeginAtZero() {
		return scaleBeginAtZero;
	}
	
	/**
	 * Sets whether the scale should start at zero, or an order of magnitude
	 * down from the lowest value
	 *
	 * @param scaleBeginAtZero
	 * @return
	 */
	public ChartOptions setScaleBeginAtZero(boolean scaleBeginAtZero) {
		this.scaleBeginAtZero = scaleBeginAtZero;
		return this;
	}
	
	public boolean getBezierCurve() {
		return bezierCurve;
	}
	
	/**
	 * Sets whether the line between points in a line chart is curved.
	 *
	 * @param bezierCurve
	 * @return
	 */
	public ChartOptions setBezierCurve(boolean bezierCurve) {
		this.bezierCurve = bezierCurve;
		return this;
	}
	
	public boolean getShowFill() {
		return showFill;
	}
	
	/**
	 * Sets whether the area below a line is filled in a line chart.
	 *
	 * @param showFill
	 * @return
	 */
	public ChartOptions setShowFill(boolean showFill) {
		this.showFill = showFill;
		return this;
	}
	
	public int getPointDotRadius() {
		return pointDotRadius;
	}
	
	/**
	 * Sets the radius of a dot in a line or radar chart. Set to 0 to draw no
	 * dots.
	 *
	 * @param pointDotRadius
	 * @return
	 */
	public ChartOptions setPointDotRadius(int pointDotRadius) {
		this.pointDotRadius = pointDotRadius;
		return this;
	}
	
	public int getStrokeWidth() {
		return strokeWidth;
	}
	
	/**
	 * Sets the width of the outline of a data segment.
	 *
	 * @param pointDotRadius
	 * @return
	 */
	public ChartOptions setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
		return this;
	}
	
	public boolean getScaleShowLabels() {
		return scaleShowLabels;
	}
	
	/**
	 * Sets whether or not to show labels on the scale of the chart.
	 *
	 * @param scaleShowLabels
	 * @return
	 */
	public ChartOptions setScaleShowLabels(boolean scaleShowLabels) {
		this.scaleShowLabels = scaleShowLabels;
		return this;
	}
	
	public boolean getScaleIntegersOnly() {
		return scaleIntegersOnly;
	}
	
	/**
	 * Sets whether or not to use integer values only for the charts.
	 *
	 * @param scaleIntegersOnly
	 */
	public ChartOptions setScaleIntegersOnly(boolean scaleIntegersOnly) {
		this.scaleIntegersOnly = scaleIntegersOnly;
		return this;
	}

	public boolean isResponsive() {
		return responsive;
	}

	/**
	 * Sets whether or not the chart should be responsive and resize when the
	 * browser does.
	 *
	 * @param responsive
	 */
	public ChartOptions setResponsive(boolean responsive) {
		this.responsive = responsive;
		return this;
	}
	
	public int getPointHitDetectionRadius() {
		return pointHitDetectionRadius;
	}
	
	/**
	 * Sets the amount extra to add to the radius to cater for hit detection 
	 * outside the drawn point. This is the mouse radius for tooltips.
	 * 
	 * @param pointHitDetectionRadius
	 */
	public void setPointHitDetectionRadius(int pointHitDetectionRadius) {
		this.pointHitDetectionRadius = pointHitDetectionRadius;
	}

	JsonObject toJson() {
		JsonObject result = new JsonObject();
		result.add("animation", animation);
		result.add("showTooltips", showToolTips);
		result.add("scaleBeginAtZero", scaleBeginAtZero);
		result.add("bezierCurve", bezierCurve);
		result.add("datasetFill", showFill);
		result.add("pointDot", pointDotRadius > 0 ? true : false);
		result.add("pointDotRadius", pointDotRadius);
		result.add("showStroke", strokeWidth > 0 ? true : false);
		result.add("strokeWidth", strokeWidth);
		result.add("scaleShowLabels", scaleShowLabels);
		result.add("scaleIntegersOnly", scaleIntegersOnly);
		result.add("responsive", responsive);
		result.add("pointHitDetectionRadius", pointHitDetectionRadius);
		return result;
	}
	
}

