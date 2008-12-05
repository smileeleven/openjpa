/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.openjpa.persistence.query;

import javax.persistence.Expression;

/**
 * Denotes a range used by MEMBER OF operation.
 * 
 * @author Pinaki Poddar
 *
 */
public class RangeExpression extends BinaryOperatorExpression {
	public RangeExpression(Expression e1, Expression e2) {
		super(e1, BinaryFunctionalOperator.RANGE, e2);
	}
	
	@Override
	public String asExpression(AliasContext ctx) {
		return "(" + ((Visitable)_e1).asExpression(ctx) 
		     + " AND " + ((Visitable)_e2).asExpression(ctx) + ")";
	}
}
