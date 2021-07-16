package modules.freeTheme.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class CoolestThingTest extends AbstractDomainTest<CoolestThing> {

	@Override
	protected CoolestThing getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(CoolestThing.MODULE_NAME, CoolestThing.DOCUMENT_NAME);
	}
}