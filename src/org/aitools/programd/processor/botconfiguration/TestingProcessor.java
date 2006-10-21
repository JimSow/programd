/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.processor.botconfiguration;

import java.net.URL;

import org.w3c.dom.Element;

import org.aitools.programd.Bot;
import org.aitools.programd.Core;
import org.aitools.programd.parser.BotsConfigurationFileParser;
import org.aitools.programd.processor.ProcessorException;
import org.aitools.util.resource.URLTools;
import org.aitools.util.xml.XML;

/**
 * The <code>sentence-splitters</code> element is a container for defining
 * strings that should cause the input to be split into sentences.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 */
public class TestingProcessor extends BotConfigurationElementProcessor
{
    /** The label (as required by the registration scheme). */
    public static final String label = "testing";

    /**
     * Creates a new SentenceSplittersProcessor using the given Core.
     * 
     * @param core the Core object to use
     */
    public TestingProcessor(Core core)
    {
        super(core);
    }

    /**
     * @see BotConfigurationElementProcessor#process(Element,
     *      BotsConfigurationFileParser)
     */
    @Override
    public String process(Element element, BotsConfigurationFileParser parser) throws ProcessorException
    {
        // Does it have an href attribute?
        if (element.hasAttribute(HREF))
        {
            parser.verifyAndProcess(element.getAttribute(HREF));
            return "";
        }
        // (otherwise...)
        Bot bot = parser.getCurrentBot();
        URL docURL = parser.getCurrentDocURL();

        bot.setTestSuitePathspec(URLTools.getURLs(XML.getChildText(element, "test-suite-path"), docURL));
        bot.setTestReportDirectory(URLTools.contextualize(docURL, XML.getChildText(element, "report-directory")));

        logger.info("Configured testing.");
        return "";
    }
}