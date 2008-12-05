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
 * Denotes e1 BETWEEN(e2 AND e3) Expression.
 * 
 * @author Pinaki Poddar
 *
 */
public class BetweenExpression extends BinaryExpressionPredicate {
	public BetweenExpression(Expression arg1, RangeExpression arg2) {
		super(arg1, BinaryConditionalOperator.BETWEEN, 
			BinaryConditionalOperator.BETWEEN_NOT, arg2);
	}
	
//	public String toJPQL(AliasContext ctx) {
//		return super.toJPQL(ctx) + " AND " + ((ExpressionImpl)arg3).toJPQL(ctx);
//	}
}
