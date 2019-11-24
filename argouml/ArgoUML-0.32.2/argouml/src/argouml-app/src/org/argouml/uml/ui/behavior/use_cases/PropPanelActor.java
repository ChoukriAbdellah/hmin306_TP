/* $Id: PropPanelActor.java 18591 2010-07-29 00:36:56Z bobtarling $
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
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
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

package org.argouml.uml.ui.behavior.use_cases;

import org.argouml.uml.ui.ActionNavigateContainerElement;
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;


/**
 * Builds the property panel for a actor.<p>
 *
 * @author jrobbins
 * @deprecated in 0.31.2 by Bob Tarling  This is replaced by the XML property
 * panels module
 */
@Deprecated
public class PropPanelActor extends PropPanelClassifier {

    /**
     * The serial version.
     */
    private static final long serialVersionUID = 7368183497864490115L;

    /**
     * Construct a new property panel for an Actor.
     */
    public PropPanelActor() {
    	super("label.actor", lookupIcon("Actor"));

    	addField("label.name", getNameTextField());
        addField("label.namespace", getNamespaceSelector());

        add(getModifiersPanel());

    	addSeparator();

    	addField("label.generalizations", getGeneralizationScroll());
        addField("label.specializations", getSpecializationScroll());

    	addSeparator();

    	addField("label.association-ends", getAssociationEndScroll());

        // The toolbar buttons that go at the top:
        addAction(new ActionNavigateContainerElement());
        addAction(new ActionNewActor());
        addAction(getActionNewReception());
        addAction(new ActionNewStereotype());
        addAction(getDeleteAction());
    }

}
