/**
 * EXPath Cryptographic Module
 * Java Library providing an EXPath Cryptographic Module
 * Copyright (C) 2015 Claudius Teodorescu
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package ro.kuberam.libs.java.digitalPublishing;

public enum DigitalPublishingError {
	
    TRANSFORMATION_FORMULA("digi-pub:transformation-formula", "The transformation formula is not supported.");

	private String code;
    private String message;

    DigitalPublishingError(String code, String message) {
    	this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public String getDescription() {
        return this.code + ", " + this.message;
    }    
    
}
