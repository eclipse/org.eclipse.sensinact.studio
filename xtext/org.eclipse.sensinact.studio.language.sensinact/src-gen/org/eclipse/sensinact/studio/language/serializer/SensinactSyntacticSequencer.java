/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
/*
 * generated by Xtext 2.9.1
 */
package org.eclipse.sensinact.studio.language.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sensinact.studio.language.services.SensinactGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class SensinactSyntacticSequencer extends AbstractSyntacticSequencer {

	protected SensinactGrammarAccess grammarAccess;
	protected AbstractElementAlias match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_a;
	protected AbstractElementAlias match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (SensinactGrammarAccess) access;
		match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_a = new TokenAlias(true, true, grammarAccess.getDSL_Expression_UnaryAccess().getLeftParenthesisKeyword_4_0());
		match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_p = new TokenAlias(true, false, grammarAccess.getDSL_Expression_UnaryAccess().getLeftParenthesisKeyword_4_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_a.equals(syntax))
				emit_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_p.equals(syntax))
				emit_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) 'not' exp=DSL_Expression_Unary
	 *     (rule start) (ambiguity) value=BOOLEAN
	 *     (rule start) (ambiguity) value=NUMBER
	 *     (rule start) (ambiguity) value=STRING
	 *     (rule start) (ambiguity) value=[DSL_REF|ID]
	 *     (rule start) (ambiguity) {DSL_Expression_And.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Diff.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Division.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Equal.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Larger.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Larger_Equal.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Minus.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Modulo.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Multiplication.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Or.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Plus.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Smaller.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Smaller_Equal.left=}
	 */
	protected void emit_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {DSL_Expression_And.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Diff.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Division.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Equal.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Larger.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Larger_Equal.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Minus.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Modulo.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Multiplication.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Or.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Plus.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Smaller.left=}
	 *     (rule start) (ambiguity) {DSL_Expression_Smaller_Equal.left=}
	 */
	protected void emit_DSL_Expression_Unary_LeftParenthesisKeyword_4_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
