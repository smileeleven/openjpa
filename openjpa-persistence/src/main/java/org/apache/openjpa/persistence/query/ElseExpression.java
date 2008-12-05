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

/**
 * Else clause in a Case Statement.
 * 
 * @author Pinaki Poddar
 *
 */
public class ElseExpression extends ExpressionImpl {
	private final CaseExpressionImpl _caseClause;
	private final Object _elseClause;
	
	public ElseExpression(CaseExpressionImpl owner, Object op) {
		_caseClause = owner;
		_elseClause = op;
	}
	
	@Override
	public String asExpression(AliasContext ctx) {
		return _caseClause.toJPQL(ctx) 
		    + " ELSE " + toJPQL(ctx, _elseClause) 
		    + " END ";
	}
	
	@Override
	public String asProjection(AliasContext ctx) {
		return _caseClause.toJPQL(ctx) 
		     + " ELSE " + toJPQL(ctx, _elseClause) 
		     + " END ";
	}
		
	String toJPQL(AliasContext ctx, Object o) {
		if (o instanceof Visitable) {
			return ((Visitable)o).asExpression(ctx);
		}
		return o.toString();
	}
	
	String asProjection(AliasContext ctx, Object o) {
		if (o instanceof Selectable) {
			return ((Selectable)o).asProjection(ctx);
		}
		return o.toString();
	}
}
