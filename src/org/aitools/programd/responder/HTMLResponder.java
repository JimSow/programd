/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.responder;

/**
 * Responsible for handling requests that come via HTTP, and delivering the
 * response via dynamically-generated HTML based on user-designed templates.
 * This has been totally re-worked from older versions. The authentication stuff
 * is now handled by {@link HTMLResponderManager}, so someone could more easily
 * replace all that without disturbing the HTMLResponder code (which is
 * obviously quite simple).
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 * @version 4.5
 */
public class HTMLResponder extends AbstractXMLResponder implements ServletRequestResponder
{
    /**
     * Creates a new HTMLResponder.
     * 
     * @param responsibleManager the manager that is responsible for this
     *            responder
     * @param botidToRespondFor the botid to respond for
     * @param templateName the template name to use
     */
    public HTMLResponder(HTMLResponderManager responsibleManager, String botidToRespondFor, String templateName)
    {
        super(responsibleManager, botidToRespondFor, templateName);
    }
}