/* $Id: PropPanelSubsystem.java 18591 2010-07-29 00:36:56Z bobtarling $
 *****************************************************************************
 * Copyright (c) 2009 Contributors - see below
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    tfmorris
 *****************************************************************************
 *
 * Some portions of this file was previously release using the BSD License:
 */

// Copyright (c) 1996-2007 The Regents of the University of California. All
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

package org.argouml.uml.ui.model_management;

import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.ui.AbstractActionNewModelElement;
import org.argouml.uml.ui.UMLLinkedList;
import org.argouml.uml.ui.foundation.core.UMLClassifierFeatureListModel;

/**
 * A property panel for UML subsystems.
 * <p>
 * TODO: This is unused and only partially complete. It needs to implement all
 * Classifier properties as well as the Subsystem specific isInstantiable
 * property.
 * @deprecated in 0.31.2 by Bob Tarling  This is replaced by the XML property
 * panels module
 */
@Deprecated
public class PropPanelSubsystem extends PropPanelPackage {

    private JScrollPane featureScroll;

    private static UMLClassifierFeatureListModel featureListModel =
        new UMLClassifierFeatureListModel();

    /**
     * Construct a property panel for a Subsystem.
     */
    public PropPanelSubsystem() {
        super("label.subsystem", lookupIcon("Subsystem"));

        addField(Translator.localize("label.available-features"),
                getFeatureScroll());

        addAction(new ActionNewOperation());
    }

    /**
     * Add a new operation to this classifier.
     *
     * @author mvw@tigris.org
     */
    private static class ActionNewOperation
        extends AbstractActionNewModelElement {

        /**
         * The key for the action name.
         */
        private static final String ACTION_KEY = "button.new-operation";

        /**
         * The constructor.
         */
        public ActionNewOperation() {
            super(ACTION_KEY);
            putValue(Action.NAME, Translator.localize(ACTION_KEY));
        }

        /*
         * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            Object target = TargetManager.getInstance().getModelTarget();
            if (Model.getFacade().isAClassifier(target)) {
                Project p = ProjectManager.getManager().getCurrentProject();
                Object returnType = p.getDefaultReturnType();
                Object newOper =
                    Model.getCoreFactory()
                        .buildOperation(target, returnType);
                TargetManager.getInstance().setTarget(newOper);
                super.actionPerformed(e);
            }
        }

        /**
         * The UID.
         */
        private static final long serialVersionUID = -5149342278246959597L;
    }

    /**
     * Returns the featureScroll.
     *
     * @return JScrollPane
     */
    public JScrollPane getFeatureScroll() {
        if (featureScroll == null) {
            JList list = new UMLLinkedList(featureListModel);
            featureScroll = new JScrollPane(list);
        }
        return featureScroll;
    }

    /**
     * The UID.
     */
    private static final long serialVersionUID = -8616239241648089917L;
}
