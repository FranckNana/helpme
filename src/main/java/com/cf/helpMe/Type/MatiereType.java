package com.cf.helpMe.Type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MatiereType {
	
	 	MATH("MATH"),
	 	PC("PC"),
	 	SVT("SVT"),
	 	FR("FR"),
	 	ANG("ANG"),
	 	ALL("ALL"),
	 	PHILOS("PHILOS"),
	 	HG("HG");
	 	
		private String label;
		
		
		private MatiereType(){}
		
		private MatiereType(String label) {
			this.label = label;
		}
		
		@JsonCreator
		public static MatiereType of(String label) {
			for(MatiereType value: values()) {
				if(value.label.equals(label)) {
					return value;
				}
			}
			return null;
		}
		
		@JsonValue
		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}
}
