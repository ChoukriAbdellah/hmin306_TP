/* $Id: UMLInitialValueExpressionModel.java 18215 2010-04-06 17:53:52Z bobtarling $
 *****************************************************************************
 * Copyright (c) 2009 Contributors - see below
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michiel van der Wulp
 *    Bob Tarling
 *****************************************************************************
 *
 * Some portions of this file was previously release using the BSD License:
 */

// Copyright (c) 2008-2009 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.core.propertypanels.ui;

import org.argouml.model.Model;

/**
 * @author jrobbins
 * @author jaap.branderhorst
 * @author penyaskito
 */
class UMLInitialValueExpressionModel
    extends UMLExpressionModel {

    public UMLInitialValueExpressionModel(Object target) {
        super(target, "initialValue");
    }

    /**
     * @return
     * @see org.argouml.uml.ui.UMLExpressionModel2#getExpression()
     */
    @Override
    public Object getExpression() {
        return Model.getFacade().getInitialValue(getTarget());
    }

    @Override
    public Object newExpression(String lang, String body) {
        return Model.getDataTypesFactory().createExpression(lang, body);
    }

    /**
     * @param expr
     * @see org.argouml.uml.ui.UMLExpressionModel2#setExpression(java.lang.Object)
     */
    @Override
    public void setExpression(Object expression) {
        Object target = getTarget();
        assert (expression == null) || Model.getFacade().isAExpression(expression);
        /* If we do not set it to null first, then we get a MDR DebugException: */
        Model.getCoreHelper().setInitialValue(target, null);
        Model.getCoreHelper().setInitialValue(target, expression);
    }
}
